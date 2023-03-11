package org.example.PokeObcjectCreator;

import org.example.model.PokeType;
import org.example.model.Pokemon;
import org.example.model.Status;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PokemonCreator {

    public PokemonCreator(){

    }
    public void createPoke() {
        Pokemon pokemon = new Pokemon("Rattata",1,100,100,5,10,100,2,10, Status.Undefeated, PokeType.Normal);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Pokemons\\"+pokemon.getName()));
            outputStream.writeObject(pokemon);
            outputStream.close();
            System.out.println("Udało sie stworzyc pokemona: " +pokemon.getName());
        } catch(Exception e) {
            System.out.println("Nie udało sie stworzyc pokemona");
            e.printStackTrace();
        }
    }
}
