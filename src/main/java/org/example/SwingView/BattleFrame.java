package org.example.SwingView;

import org.example.model.Pokemons.WildPokemon;

import javax.swing.*;
import java.awt.*;

public class BattleFrame extends JButton{

    private WildPokemon pokemon;
    public static int number = 0;
    public BattleFrame(WildPokemon pokemon){
        this.pokemon = pokemon;
        number++;
        setPreferredSize(new Dimension(150,150));
        setSize(new Dimension(150,150));
        setFocusable(false);
        setText(number + ". "+pokemon.getName());
        addActionListener(e -> {
            setBackground(Color.GREEN);
        });
    }

}
