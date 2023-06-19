package org.example.model;

import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.Pokemon;
import org.example.model.Pokemons.WildPokemon;

import java.util.ArrayList;
import java.util.List;

public class TeamsBattle {
    private final int maxRound = 10;
    private int round;
    private final StringBuilder report;
    private List<Pokemon> playersTeamCopy;
    private final List<Pokemon> playersTeam;
    private List<WildPokemon> enemyTeamCopy;
    private final List<WildPokemon> enemyTeam;
    private List<AbstractPokemon> attacksQueue;

    public TeamsBattle(List<Pokemon> playersTeam, List<WildPokemon> enemyTeam){
        round = 1;
        report = new StringBuilder();
        this.playersTeam = playersTeam;
        this.enemyTeam = enemyTeam;
    }
    public String letsBattle(){
        beforeFight();
        for(;round<=maxRound;round++){
            round();
        }
        return report.toString();
    }
    private void round(){

    }
    private void beforeFight(){
        report.append("Rozpoczela sie walka pomiedzy:\n");
        getTeamMemberNames();
        copyTeams();
    }
    private void getTeamMemberNames(){
        report.append("Druzyna 1:");
        for(int i = 0; i< playersTeam.size(); i++){
            report.append("\n"+(i+1)+". "+ playersTeam.get(i).getName());
        }
        report.append("Druzyna 2:");
        for(int i = 0; i< enemyTeam.size(); i++){
            report.append("\n"+(i+1)+". "+ enemyTeam.get(i).getName());
        }
    }
    private void copyTeams(){
        playersTeamCopy = new ArrayList<Pokemon>();
        enemyTeamCopy = new ArrayList<WildPokemon>();
        for(int i=0;i<playersTeam.size();i++){
            playersTeamCopy.add(new Pokemon(playersTeam.get(i)));
        }
        for(int i=0;i<enemyTeam.size();i++){
            enemyTeam.add(new WildPokemon(enemyTeam.get(i)));
        }
    }


}
