package org.example.SwingView;

import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class PokemonPanel extends JPanel {

    Pokemon pokemon;
    JLabel health,experience;
    JButton moreButton;
    public PokemonPanel(Optional<Pokemon> pokemon){
        setLayout(null);
        if(pokemon.isPresent()) {
            this.pokemon = pokemon.get();

            health = new JLabel("Health: "+pokemon.get().getHitPoint() + "//" + pokemon.get().getMaxHitPoint());
            health.setBounds(10, 17, 110, 15);

            experience = new JLabel("Exp: "+pokemon.get().getExperience());
            experience.setBounds(10,32,110,15);

            moreButton = new JButton("Wiecej...");
            moreButton.setBounds(10,80,97,15);
            moreButton.setBackground(Color.yellow);
            moreButton.addActionListener(e -> {
                MainSwingView.getInstance().showPokemonFrame(this.pokemon);
            });

            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.black), pokemon.get().getName()+" "+pokemon.get().getLvl()+" lvl"));

            add(health);
            add(experience);
            add(moreButton);
        }else {
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.black), "Wolny slot"));
            JLabel emptyLabel = new JLabel("Zlap pokemona pierw");
            emptyLabel.setBounds(10,10,80,30);
            add(emptyLabel);
        }
    }
}
