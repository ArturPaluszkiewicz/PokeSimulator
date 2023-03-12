package org.example.PokeObcjectCreator;

import org.example.model.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import java.util.ArrayList;

public class LocationCreator {

    public LocationCreator(){}

    public void createLocation(){
        List<WildPokemon> pokes = new ArrayList<WildPokemon>();
        pokes.add(new WildPokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal));
        List<String> conLoc = new ArrayList<String>();
        conLoc.add("Viridian City");
        List<String> actions = new ArrayList<String>();
        actions.add("pusto");
        Location location = new Location("Pallet","Pallet - miasto poczatku",pokes,conLoc,actions);

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Location\\"+location.getName()));
            outputStream.writeObject(location);
            outputStream.close();
            System.out.println("Udało sie stworzyc lokacje: "+location.getName());
        } catch (Exception e) {
            System.out.println("Nie udało sie stworzyc lokacji");
            e.printStackTrace();
        }
    }
}
