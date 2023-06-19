package org.example.model.Battle;

import org.example.model.LootSystem;
import org.example.model.Pokemons.Pokemon;
import org.example.model.Pokemons.Status;
import org.example.model.Pokemons.WildPokemon;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewBattle {

    private final int maxRound = 10;
    private int actualRound;
    private final Pokemon pokemon;
    private final WildPokemon wildPokemon;
    private List<QueueEntity> queue;
    private StringBuilder report;
    private final LootSystem loot;
    private Winner winner;

    public NewBattle(Pokemon pokemon , WildPokemon wildPokemon){
        this.pokemon = pokemon;
        this.wildPokemon = wildPokemon;
        queue = new ArrayList<QueueEntity>();
        actualRound = 1;
        winner = Winner.NONE;
        loot = wildPokemon.getLoot();
        report = new StringBuilder();
    }
    public String letsBattle(){
        if (checkIfCanBattle()) {
            beforeBattleStarts();
            for (; actualRound <= maxRound; actualRound++) {
                round();
                if (winner != Winner.NONE) {
                    break;
                }
            }
            if(winner==Winner.NONE){
                winner=Winner.DRAW;
            }
            afterBattle();
        }
        return report.toString();
    }
    private void beforeBattleStarts(){
        report.append("Rozpoczela sie walka pomiedzy "+pokemon.getName()+" a dzikim "+wildPokemon.getName()+".\n");
    }
    private void initQueue(){
        queue.add(new QueueEntity(pokemon, QueueEntity.Team.TEAM_A));
        queue.add(new QueueEntity(wildPokemon, QueueEntity.Team.TEAM_B));
        pokemon.getChosenTemplate().getMove(actualRound).ifPresent(pokeMoves -> queue.add(new QueueEntity(pokeMoves, QueueEntity.Team.TEAM_A)));
        wildPokemon.getChosenTemplate().getMove(actualRound).ifPresent(pokeMoves -> queue.add(new QueueEntity(pokeMoves, QueueEntity.Team.TEAM_B)));
        sortQueue();
    }
    private void sortQueue(){
        queue.sort((p1,p2) -> Integer.compare(p2.getInitiative(), p1.getInitiative()));
    }
    private void attack(QueueEntity attackers){
        if(attackers.getType()==QueueEntity.PokemonOrMove.POKEMON){
            int dmg = wildPokemon.takeHit(attackers.getPokemon().get().getAttack());
            report.append(attackers.getPokemon().get().getName()+" zaatakowal "+wildPokemon.getName()+" za "+dmg+" obrazen.\n");
        } else if (attackers.getType()==QueueEntity.PokemonOrMove.WILD_POKEMON) {
            int dmg = pokemon.takeHit(attackers.getWildPokemon().get().getAttack());
            report.append(attackers.getWildPokemon().get().getName()+" zaatakowal "+pokemon.getName()+" za "+dmg+" obrazen.\n");
        } else if (attackers.getType()==QueueEntity.PokemonOrMove.MOVE) {
            if(attackers.getTeam()==QueueEntity.Team.TEAM_A){
                report.append(attackers.getMove().get().useMove(wildPokemon));
            }else if(attackers.getTeam()== QueueEntity.Team.TEAM_B){
                report.append(attackers.getMove().get().useMove(pokemon));
            }
        }
        if(attackers.useMoveOrAttack()==0){ // decrease attackers initiative and attacks left, if attacksleft = 0 attackers is removed from queue
            queue.remove(attackers);
        }
    }
    private void round(){
        report.append("\nRunda: "+actualRound+"\n");
        report.append(pokemon.getName()+": "+pokemon.getHitPoint()+" zdrowia\n");
        report.append(wildPokemon.getName()+": "+wildPokemon.getHitPoint()+" zdrowia\n");
        initQueue();
        do {
            sortQueue();
            attack(queue.get(0));
            if(checkWinnerCondition()){
                break;
            }
        }while (queue.size()>0);
    }
    private void afterBattle(){
        if(winner==Winner.DRAW){
            report.append("\n\nZadnemu pokemonowi nie udalo sie zdominowac przeciwnika. \nWalka zakonczyla sie remisem.");
        } else if (winner==Winner.TRAINERS_POKEMON) {
            report.append("\nGratulacje!\nWygrales walke z dzikim "+wildPokemon.getName()+" i zdobyles nagrody:\n");
        } else if (winner==Winner.WILD_POKEMON) {
            report.append("\n\nNiestety nie udalo ci sie pokonac dzikiego "+wildPokemon.getName()+".");

        } else {
            report.append("Koniec walki!");
        }
        saveReport();
    }
    private boolean checkIfCanBattle() {
        if(pokemon.getStatus().equals(Status.Defeated)||pokemon.getHitPoint()<=0){
            report.append("Twoj pokemon jest nie zdolny do Walki.");
            return false;
        } else if (wildPokemon.getStatus().equals(Status.Defeated)||wildPokemon.getHitPoint()<=0) {
            report.append("Przeciwnik juz jest pokonoany.");
            return false;
        }
        return true;
    }
    private boolean checkWinnerCondition(){
        if (wildPokemon.checkIfDefeated()){
            report.append(wildPokemon.getName()+" jest niezdolny do dalszej walki.\n");
            winner=Winner.TRAINERS_POKEMON;
            return true;
        }else if (pokemon.checkIfDefeated()){
            report.append(pokemon.getName()+" jest niezdolny do dalszej walki.\n");
            winner=Winner.WILD_POKEMON;
            return true;
        }
        return false;
    }
    private void saveReport() {
        LocalDateTime reportDateTime = LocalDateTime.now();
        String reportFileName = new StringBuilder()
                .append(reportDateTime.getYear())
                .append("_")
                .append(reportDateTime.getMonth())
                .append("_")
                .append(reportDateTime.getDayOfMonth())
                .append("_")
                .append(reportDateTime.getHour())
                .append("_")
                .append(reportDateTime.getMinute())
                .append("_")
                .append(reportDateTime.getSecond())
                .append("_")
                .append(pokemon.getName())
                .append("_VS_")
                .append(wildPokemon.getName()).toString();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\BattleReports\\"+reportFileName));
            outputStream.writeObject(report);
            outputStream.close();
            System.out.println("Udało sie stworzyc zapisac raportu z walki");
        } catch (Exception e) {
            System.out.println("Nie udało sie stworzyc zapisac raportu z walki");
            e.printStackTrace();
        }
    }
    private enum Winner{
        TRAINERS_POKEMON, WILD_POKEMON, DRAW, NONE
    }
}
