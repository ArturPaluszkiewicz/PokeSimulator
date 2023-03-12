package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Location implements Serializable {

    private String name;
    private String description;
    private List<Pokemon> pokemonsToBattle;
    private List<String> connectedLocation;
    private List<String> action;

    public Location() {
        name = "Pallet";
        description = "Pallet - miasto startowe";
        pokemonsToBattle = new ArrayList<Pokemon>();
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

    public Location(String name, String description, List<Pokemon> pokemonsToBattle, List<String> connectedLocation, List<String> action) {
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

    public List<Pokemon> getPokemonsToBattle() {
        return pokemonsToBattle;
    }

    public List<String> getConnectedLocation() {
        return connectedLocation;
    }

    public List<String> getAction() {
        return action;
    }
}
