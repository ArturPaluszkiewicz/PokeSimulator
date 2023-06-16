package org.example.SwingView.PokemonDetails;

import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PokemonFrame extends JPanel {
    private Pokemon pokemon;
    private JButton stats,moves,perks,templates;

    private JPanel movesPanel,centerPanel;
    private JLabel centerLabel,name;

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
        stats.setBounds(30,40,100,40);
        stats.setFocusable(false);
        stats.addActionListener(e -> {
            centerPanel.removeAll();
            centerLabel.setText("Statystyki:");
            centerPanel.add(new StatisticsPanel(pokemon));
            repaint();
        });
        moves = new JButton("Ruchy");
        moves.setBounds(140,40,100,40);
        moves.setFocusable(false);
        moves.addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new MovesPanel(pokemon));
            centerLabel.setText("Ruchy:");
            repaint();
        });
        perks = new JButton("Perks");
        perks.setBounds(250,40,100,40);
        perks.setFocusable(false);
        perks.addActionListener(e ->{
            centerPanel.removeAll();
            centerPanel.add(new PerksPanel(pokemon));
            centerLabel.setText("Wzmocnienia:");
            repaint();
        });
        templates = new JButton("Szablony");
        templates.setBounds(360,40,100,40);
        templates.setFocusable(false);
        templates.addActionListener(e ->{
            centerPanel.removeAll();
            centerPanel.add(new TemplatePanel());
            centerLabel.setText("Menager Szablonow:");
            repaint();
        });

        centerLabel = new JLabel("Statystyki:");
        centerLabel.setBounds(80,100,300,15);

        centerPanel = new JPanel();
        centerPanel.setBounds(80,120,320,300);
        centerPanel.setLayout(null);

        add(centerPanel);
        add(moves);
        add(perks);
        add(templates);
        add(stats);
        add(name);
        add(centerLabel);
        centerPanel.add(new StatisticsPanel(pokemon));
        setVisible(true);
    }

}
