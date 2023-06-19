package org.example.SwingView;

import org.example.model.Battle.Battle;
import org.example.model.Battle.NewBattle;
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
            int chosenPokemon = JOptionPane.showOptionDialog(
                    null,
                    "Ktorym pokemonem chcesz walczyc ?",
                    "Walka",
                    0,
                    0,
                    null,
                    MainSwingView.player.get().getPokemonsName(),
                    1);
            if (chosenPokemon<6&&chosenPokemon>=0){
                new NewBattle(MainSwingView.player.get().getPokemons().get(chosenPokemon).get(),pokemon).letsBattle();
            }
            if(pokemon.checkIfDefeated()){
                setBackground(Color.GRAY);
            }
        });
    }

}
