package org.example.model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PokemonCreator {

    public static void main(String[] args) {
        createPoke();
        System.out.println("Udało sie stworzyć pokemona");
    }
    static public void createPoke() {
        Pokemon pokemon = new Pokemon("Rattata",1,100,100,5,10,100,2,10,Status.Undefeated,PokeType.Normal);
            try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Pokemons\\Mew"));
            outputStream.writeObject(pokemon);
            outputStream.close();
        } catch(
        Exception e)
        {
            e.printStackTrace();
        }
    }
}
