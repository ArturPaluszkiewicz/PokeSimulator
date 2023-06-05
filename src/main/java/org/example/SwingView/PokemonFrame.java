package org.example.SwingView;

import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PokemonFrame extends JPanel {
    private Pokemon pokemon;
    private JButton stats,moves,perks;
    private JTextArea statistics;
    private JLabel centerLabel,name,exp,type,attack,defense,spAttack,spDefense,nrOfAttacks,initiative,health,maxHealth;

    public PokemonFrame(Pokemon pok){
        pokemon=pok;
        setBounds(0,0,500,500);
        setLayout(null);

        name = new JLabel(pokemon.getName()+"("+pokemon.getLvl()+" lvl):");
        name.setFont(new Font("Arial",Font.PLAIN,20));
        name.setBounds(0,10, 500,30);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setHorizontalTextPosition(SwingConstants.CENTER);

        stats = new JButton("Staty");
        stats.setBounds(80,40,100,40);
        stats.addActionListener(e -> {
            resetCenterPane();
            add(statistics);
            repaint();
        });
        moves = new JButton("Ruchy");
        moves.setBounds(190,40,100,40);
        moves.addActionListener(e -> {
            resetCenterPane();
            repaint();
        });
        perks = new JButton("Perks");
        perks.setBounds(300,40,100,40);
        perks.addActionListener(e ->{
            resetCenterPane();
            repaint();
        });

        centerLabel = new JLabel("Statystyki:");
        centerLabel.setBounds(80,100,100,15);

        statistics = new JTextArea(setStatisticsText());
        statistics.setEditable(false);
        statistics.setFocusable(false);
        statistics.setFont(new Font("Arial",Font.BOLD,13));
        statistics.setBounds(80,120,320,300);
        statistics.setBorder(BorderFactory.createLineBorder(Color.black));

        add(centerLabel);
        add(stats);
        add(moves);
        add(perks);
        add(name);
        add(statistics);
        setVisible(true);
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
    private void resetCenterPane(){
        removeAll();
        add(stats);
        add(moves);
        add(perks);
        add(name);
    }
}
