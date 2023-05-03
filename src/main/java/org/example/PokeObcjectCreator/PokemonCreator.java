package org.example.PokeObcjectCreator;

import org.example.model.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PokemonCreator {


    private String name;
    private int lvl;
    private int maxHitPoint;
    private int hitPoint;
    private int defence;
    private int attack;
    private int specialAttack;
    private int specialDefence;
    private int initiative;
    private int numberOfAttack;
    private int slowAfterAttack;
    private PokeType pokeType;
    private List<PokeMoves> tempMoves;
    public PokemonCreator(){
    }
    public void createPoke() {
        name = "Rattata";
        lvl = 1;
        maxHitPoint = 100;
        defence = 10;
        attack = 20;
        specialAttack = 30;
        specialDefence = 20;
        initiative = 100;
        numberOfAttack = 2;
        slowAfterAttack = 10;
        PokeType pokeType = PokeType.Normal;
        List<PokeMoves> tempMoves = new ArrayList<>();
        tempMoves.add(new PokeMoves("Scratch"));
        tempMoves.add(new PokeMoves("Quick Attack"));
        tempMoves.add(new PokeMoves("Bite"));
        List<PokePerks> perks = new ArrayList<PokePerks>();
        Pokemon pokemon = new Pokemon(name,lvl,maxHitPoint,defence,attack,specialAttack,specialDefence,initiative,numberOfAttack,slowAfterAttack,pokeType,tempMoves,perks);
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
