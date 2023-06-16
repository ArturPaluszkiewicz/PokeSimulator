package org.example.SwingView.PokemonDetails;

import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JTextArea {

    private Pokemon pokemon;

    public StatisticsPanel(Pokemon pokemon){
        this.pokemon = pokemon;

        setText(setStatisticsText());
        setEditable(false);
        setFocusable(false);
        setFont(new Font("Arial",Font.BOLD,13));
        setBounds(0,0,320,300);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private String setStatisticsText(){
        return new StringBuilder()
                .append("                   Głowne Statystyki:")
                .append("\nZycie:  "+pokemon.getHitPoint()+"\\"+pokemon.getMaxHitPoint())
                .append("\nDoswiadczenie:  "+pokemon.getExperience())
                .append("\nTyp:  "+ pokemon.getType())
                .append("\nAtak:  "+pokemon.getAttack())
                .append("\nObrona:  "+pokemon.getDefence())
                .append("\nAtak specjalny:  "+pokemon.getSpecialAttack())
                .append("\nObrona specjalna:  "+pokemon.getSpecialDefense())
                .append("\nIlosc attakow na runde:  "+pokemon.getNumberOfAttack())
                .append("\nInicjatywa:  "+pokemon.getInitiative())
                .append("\n                 Dodatkowe Statystyki:")
                .append("\nSpadek inicjatywy po ataku:  "+pokemon.getSlowAfterAttack())
                .toString();
    }
}
