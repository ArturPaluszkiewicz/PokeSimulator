package org.example.PokeObcjectCreator;

import org.example.model.PokeMoves;
import org.example.model.PokeType;
import org.example.model.Pokemon;
import org.example.model.Status;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PokemonCreator {

    public PokemonCreator(){

    }
    public void createPoke() {
        List<PokeMoves> tempMoves = new ArrayList<PokeMoves>();
        tempMoves.add(new PokeMoves("Scratch"));
        tempMoves.add(new PokeMoves("QuickAttack"));
        tempMoves.add(new PokeMoves("Bite"));
        tempMoves.add(new PokeMoves("SuperFang"));
        Pokemon pokemon = new Pokemon("Rattata",1,100,100,5,10,30,20,100,2,10, Status.Undefeated, PokeType.Normal,tempMoves);
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
