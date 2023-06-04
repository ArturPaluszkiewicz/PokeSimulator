package org.example.SwingView;

import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class PokemonPanel extends JLabel {

    Pokemon pokemon;
    JLabel health;
    public PokemonPanel(Optional<Pokemon> pokemon){
        setLayout(null);
        if(pokemon.isPresent()) {
            this.pokemon = pokemon.get();
            health = new JLabel(pokemon.get().getHitPoint() + "//" + pokemon.get().getMaxHitPoint());
            health.setBounds(10, 10, 80, 30);
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.black), pokemon.get().getName()));
            add(health);
        }else {
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.black), "Wolny slot"));
            JLabel emptyLabel = new JLabel("Zlap pokemona pierw");
            emptyLabel.setBounds(10,10,80,30);
            add(emptyLabel);
        }
    }
}
