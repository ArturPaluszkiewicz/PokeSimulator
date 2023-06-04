package org.example.model;

import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class Battle {

    private final Pokemon trainersPokemon;
    private final WildPokemon wildPokemon;
    private String battleReport;
    private PokeWinner winnerPokemon;
    private PokeBattleToken pokeBattleToken;
    private final AbstractPokemon pokeTr;
    private final AbstractPokemon pokeWild;
    private Map<Integer, PokeMoves> trainerPokeMoves;

    public Battle(Pokemon trainersPokemon, WildPokemon wildPokemon){
        this.trainersPokemon = trainersPokemon;
        this.wildPokemon = wildPokemon;
        this.pokeTr = new Pokemon(trainersPokemon);
        this.pokeWild = new WildPokemon(wildPokemon);
        this.winnerPokemon = PokeWinner.NONE;
        this.pokeBattleToken = PokeBattleToken.NONE;
        this.battleReport = "";
    }

    public String letsBattle(){
        this.trainerPokeMoves=trainersPokemon.getBattleTemplate();
        if(checkIfCanBattle()) {
            startBattle();
            duringBattle();
            endBattle();
        }
        saveReport();
        return battleReport;
    }

    private void startBattle(){
            battleReport += ("Rozpoczela się walka pomiedzy twoim " + trainersPokemon.getName() + " a dzikim " + wildPokemon.getName() + " !\n");
    }
    private void duringBattle(){
        for(int i=1;i<=10;i++){
            battleReport += ("Runda "+i+"\n");
            battleReport += (">"+pokeTr.getName()+": "+pokeTr.getHitPoint()+" zdrowia\n");
            battleReport += (">"+pokeWild.getName()+": "+pokeWild.getHitPoint()+" zdrowia\n");
            useMoves(i);
            for(int j = 0; j<(trainersPokemon.getNumberOfAttack()+wildPokemon.getNumberOfAttack()); j++){
                battleTokenAssign();
                pokeAttack();
                if (!winnerPokemon.equals(PokeWinner.NONE)) {
                    return;
                }
            }
//    End of round
            endOfRound();
        }
// End of battle
        winnerPokemon = PokeWinner.DRAW;
    }

    private void useMoves(int numberOfRound) {
        if(trainerPokeMoves.containsKey(numberOfRound)){
            battleReport+=trainerPokeMoves.get(numberOfRound).useMove(pokeTr,pokeWild);
        }
    }
    private void battleTokenAssign(){
        if(pokeTr.getNumberOfAttack()>0 && pokeWild.getNumberOfAttack()>0) {
            if (pokeTr.getInitiative() > pokeWild.getInitiative()) { // atak pokemona gracza (wieksza inicjawtywa)
                pokeBattleToken = PokeBattleToken.TRAINERS_POKEMON;
            } else if (pokeTr.getInitiative() == pokeWild.getInitiative()) {
                if (pokeTr.getNumberOfAttack() >= pokeWild.getNumberOfAttack()) { // atak pokemona gracza (rowna inicjatywa ale wieksza badz rowna ilosc atakow)
                    pokeBattleToken = PokeBattleToken.TRAINERS_POKEMON;
                } else { // atak dzikiego pokemona (rowna inicjawtywa i mniej atakow na runde)
                    pokeBattleToken = PokeBattleToken.WILD_POKEMON;
                }
            } else { // atak dzikiego pokemona(mniejsza inicjatywa)
                pokeBattleToken = PokeBattleToken.WILD_POKEMON;
            }
        }else if (pokeTr.getNumberOfAttack()>0) {
            pokeBattleToken = PokeBattleToken.TRAINERS_POKEMON;
        }else {
            pokeBattleToken = PokeBattleToken.WILD_POKEMON;
        }
    }
    private void endOfRound(){
        pokeTr.setInitiative(trainersPokemon.getInitiative());
        pokeWild.setInitiative(wildPokemon.getInitiative());
        pokeTr.setNumberOfAttack(trainersPokemon.getNumberOfAttack());
        pokeWild.setNumberOfAttack(wildPokemon.getNumberOfAttack());
    }
    private void endBattle(){
        if (winnerPokemon.equals(PokeWinner.TRAINERS_POKEMON)) {
            battleReport += ("Twoj pokemon pokonal dzikiego " + wildPokemon.getName() + ".");
        } else if (winnerPokemon.equals(PokeWinner.WILD_POKEMON)) {
            battleReport += ("Twoj pokemon został pokonany przez dzikiego " + wildPokemon.getName() + ".");
        }else {
            battleReport += ("Walka zakonczyla sie remisem.");
        }
        trainersPokemon.setHitPoint(pokeTr.getHitPoint());
        wildPokemon.setHitPoint(pokeWild.getHitPoint());
    }

    private boolean checkIfCanBattle() {
        if(trainersPokemon.getStatus().equals(Status.Defeated)||trainersPokemon.getHitPoint()<=0){
            battleReport += ("Twoj pokemon jest nie zdolny do Walki.");
            return false;
        } else if (wildPokemon.getStatus().equals(Status.Defeated)||wildPokemon.getHitPoint()<=0) {
            battleReport += ("Przeciwnik juz jest pokonoany.");
            return false;
        }
        return true;
    }
    private void pokeAttack(){
        if(pokeBattleToken.equals(PokeBattleToken.TRAINERS_POKEMON)){
            battleReport += (">>Twoj "+pokeTr.getName()+" zaatakował wrogiego "+pokeWild.getName()+" za "+pokeWild.takeHit(pokeTr.getAttack())+" obrazen.\n");
            pokeTr.slowAfterAttack();
            if(pokeWild.checkIfDefeated()){
                winnerPokemon = PokeWinner.TRAINERS_POKEMON;
                battleReport += (">Dziki "+pokeWild.getName()+" zostal pokonany.\n");
            }
        } else if (pokeBattleToken.equals(PokeBattleToken.WILD_POKEMON)) {
            battleReport += (">>Wrogi "+pokeWild.getName()+" zaatakowal twojego "+pokeTr.getName()+" za "+pokeTr.takeHit(pokeWild.getAttack())+" obrazen.\n");
            pokeWild.slowAfterAttack();
            if(pokeTr.checkIfDefeated()){
                winnerPokemon = PokeWinner.WILD_POKEMON;
                battleReport += (">Twoj "+pokeTr.getName()+" zostal pokonany.\n");
            }
        }else {
            battleReport += ("Cos poszlo nie tak w klasie pokeAttack");
        }
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
                .append(pokeTr.getName())
                .append("_VS_")
                .append(pokeWild.getName()).toString();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\BattleReports\\"+reportFileName));
            outputStream.writeObject(battleReport);
            outputStream.close();
            System.out.println("Udało sie stworzyc zapisac raportu z walki");
        } catch (Exception e) {
            System.out.println("Nie udało sie stworzyc zapisac raportu z walki");
            e.printStackTrace();
        }
    }
    private enum PokeWinner{
        TRAINERS_POKEMON, WILD_POKEMON, DRAW, NONE
    }
    private enum PokeBattleToken{
        TRAINERS_POKEMON, WILD_POKEMON, NONE
    }
}
