package org.example.model;

import org.example.model.Locations.Location;
import org.example.model.Pokemons.Entity.Ratatta;
import org.example.model.Pokemons.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Trainer implements Serializable {
    private String name;
    private List<Optional<Pokemon>> pokemons;
    private List<Pokemon> pokemonsInBox;
    private Location location;

    public Trainer(){
        name = "Chempion";
        pokemons = new ArrayList<Optional<Pokemon>>();
        pokemonsInBox = new ArrayList<Pokemon>();
        pokemons.add(Optional.of(new Ratatta()));
        pokemons.add(Optional.of(new Ratatta()));
        pokemons.add(Optional.of(new Ratatta()));
        pokemons.add(Optional.of(new Ratatta()));
        pokemons.add(Optional.empty());
        pokemons.add(Optional.empty());

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
            e.printStackTrace();
            throw new FileNotFoundException("asd");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Optional<Pokemon>> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Optional<Pokemon>> pokemons) {
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

    public String[] getPokemonsName(){
        int temp1=0;
        for(int i=0;i<6;i++){
            if(pokemons.get(i).isPresent()){
                temp1++;
            }
        }
        String[] temp2 = new String[temp1];
        for(int i = 0; i<pokemons.size();i++){
            if(pokemons.get(i).isPresent()) {
                temp2[i] = (i + 1) + "." + pokemons.get(i).get().getName();
            }
        }
        return temp2;
    }
    public void catchPokemon(Pokemon pokemon){
        boolean isFreeSlot = false;
        int witchSlotIsFree = 0;
        for(int i=0;i<6;i++){
            if(pokemons.get(i).isEmpty()){
                isFreeSlot = true;
                witchSlotIsFree = i;
                break;
            }
        }
        if(isFreeSlot){
            pokemons.add(witchSlotIsFree,Optional.of(pokemon));
        }
        else {
            pokemonsInBox.add(pokemon);
        }
    }
}
