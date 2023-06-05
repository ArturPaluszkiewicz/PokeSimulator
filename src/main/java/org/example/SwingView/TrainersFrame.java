package org.example.SwingView;

import org.example.model.Trainer;
import javax.swing.*;
import java.awt.*;

public class TrainersFrame extends JPanel {

    Trainer trainer;
    public TrainersFrame(Trainer trainer){
        this.trainer = trainer;

        setPreferredSize(new Dimension(500,500));
        setBounds(0,0,500,500);
        setLayout(null);
        setVisible(true);

        JLabel label1 = new JLabel("Twoje Pokemony:");
        label1.setBounds(150,0,350,20);
        add(label1);
        addPokemonsPanels();
    }
    private void addPokemonsPanels(){
        PokemonPanel pokemonPanel1 = new PokemonPanel(trainer.getPokemons().get(0));
        pokemonPanel1.setBounds(20*1+120*0,20*1+100*0,120,100);
        add(pokemonPanel1);
        PokemonPanel pokemonPanel2 = new PokemonPanel(trainer.getPokemons().get(1));
        pokemonPanel2.setBounds(20*2+120*1,20*1+100*0,120,100);
        add(pokemonPanel2);
        PokemonPanel pokemonPanel3 = new PokemonPanel(trainer.getPokemons().get(2));
        pokemonPanel3.setBounds(20*3+120*2,20*1+100*0,120,100);
        add(pokemonPanel3);
        PokemonPanel pokemonPanel4 = new PokemonPanel(trainer.getPokemons().get(3));
        pokemonPanel4.setBounds(20*1+120*0,20*2+100*1,120,100);
        add(pokemonPanel4);
        PokemonPanel pokemonPanel5 = new PokemonPanel(trainer.getPokemons().get(4));
        pokemonPanel5.setBounds(20*2+120*1,20*2+100*1,120,100);
        add(pokemonPanel5);
        PokemonPanel pokemonPanel6 = new PokemonPanel(trainer.getPokemons().get(5));
        pokemonPanel6.setBounds(20*3+120*2,20*2+100*1,120,100);
        add(pokemonPanel6);
    }
}
