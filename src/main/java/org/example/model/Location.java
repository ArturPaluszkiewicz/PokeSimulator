package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Location implements Serializable {

    private String name;
    private String description;
    private List<WildPokemon> pokemonsToBattle;
    private List<String> connectedLocation;
    private List<String> action;

    public Location() {
        name = "Pallet";
        description = "Pallet - miasto startowe";
        pokemonsToBattle = new ArrayList<WildPokemon>();
        WildPokemon poke1 = new WildPokemon("Rattata",1,100,100,5,10,30,20,90,2,10,Status.Undefeated,PokeType.Normal);
        WildPokemon poke2 = new WildPokemon("Caterpie",1,90,90,4,8,35,20,80,3,10,Status.Undefeated,PokeType.Normal);
        pokemonsToBattle.add(poke1);
        pokemonsToBattle.add(poke2);
        connectedLocation = new ArrayList<String>();
        action = new ArrayList<String>();
    }

    public Location(String name){
        /*
            Konstruktor do tworzenia lokacji z pliku. Podajesz nazwe pliku ktróy bedzie wyszukiwany
            w folderze resource/location. Jesli zostanie znaleziony stworzy lokacje na podstawie tego pliku,
            a jesli nie wyrzuci wyjatek. Do napisania xD
         */
    }

    public Location(String name, String description, List<WildPokemon> pokemonsToBattle, List<String> connectedLocation, List<String> action) {
        this.name = name;
        this.description = description;
        this.pokemonsToBattle = pokemonsToBattle;
        this.connectedLocation = connectedLocation;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<WildPokemon> getPokemonsToBattle() {
        return pokemonsToBattle;
    }

    public List<String> getConnectedLocation() {
        return connectedLocation;
    }

    public List<String> getAction() {
        return action;
    }
}
