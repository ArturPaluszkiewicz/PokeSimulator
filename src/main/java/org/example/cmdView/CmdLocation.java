package org.example.cmdView;

import org.example.model.Location;
import org.example.model.Pokemon;

import java.util.Scanner;

public class CmdLocation {
    private Location location;
    private boolean isInLocation;

    public CmdLocation(Location location){
        this.location=location;
        isInLocation=false;
    }

    public void enterLocation(){
        isInLocation = true;
        do{
            System.out.println("Znajdujesz sie w "+location.getName()+".");
            System.out.println("Co robisz ?");
            System.out.println("1. Pokaz opis lokacji");
            System.out.println("2. Walcz z pokemonem w lokacji");
            System.out.println("3. Przejdz do innej lokacji");
            System.out.println("4. Wroc do glownego menu");
            switch (new Scanner(System.in).nextInt()){
                case 1 -> {
                    showLocationDescriptions();
                }
                case 2 -> {
                    battleWithPokesInLocation();
                }
                case 3 -> {
                    goToOtherLocation();
                }
                case 4 -> {
                    returnToMainMenu();
                }
            }
        }while (isInLocation);
    }

    public void showLocationDescriptions(){
        System.out.println("****************************************************************************************************************************************");
        System.out.println("Opis Lokacji:");
        System.out.println(location.getDescription());
        System.out.println("****************************************************************************************************************************************");
    }
    public void battleWithPokesInLocation(){
        showPokesInLocation();
    }
    public void showPokesInLocation(){
        int i = 1;
        if(!location.getPokemonsToBattle().isEmpty()) {
            for (Pokemon poke : location.getPokemonsToBattle()) {
                System.out.println(i + ". " + poke.getName() + "(" + poke.getLvl() + "): ");
                System.out.println(" -zycie: (" + poke.getHitPoint() + "/" + poke.getMaxHitPoint() + ")");
                i++;
            }
        }else{
            System.out.println("W lokacji nie ma zadnego pokemona.");
        }
    }
    public void goToOtherLocation(){
        showConnectedLocation();
    }
    public void showConnectedLocation(){

    }

    public void returnToMainMenu(){
        isInLocation=false;
    }
}
