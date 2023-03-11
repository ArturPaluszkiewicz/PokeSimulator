package org.example.model;

import java.io.Serializable;
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
        pokemonsToBattle = null;
        connectedLocation = null;
        action = null;
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
}
