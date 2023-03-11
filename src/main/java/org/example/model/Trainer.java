package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trainer implements Serializable {
    private String name;
    private List<Pokemon> pokemons;
    private Location location;

    public Trainer(){
        name = "Chempion";
        pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pokemon("Rattata",1,100,100,5,10,100,2,10,Status.Undefeated,PokeType.Normal));
        location = new Location();
    }
    public Trainer(String url) throws FileNotFoundException {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(url));
            Trainer trainer = (Trainer) inputStream.readObject();
            name = trainer.getName();
            pokemons = trainer.getPokemons();
            location = trainer.getLocation();
            inputStream.close();
        } catch (Exception e) {
  //          e.printStackTrace();
            throw new FileNotFoundException("asd");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void saveTrainer(){
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Trainer"));
            outputStream.writeObject(this);
            outputStream.close();
        } catch(
                Exception e)
        {
            e.printStackTrace();
        }
    }
}
