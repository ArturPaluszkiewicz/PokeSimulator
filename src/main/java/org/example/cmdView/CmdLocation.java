package org.example.cmdView;

import org.example.model.*;

import java.util.Scanner;

public class CmdLocation {
    private Location location;
    private Trainer trainer;
    private boolean isInLocation;

    public CmdLocation(Location location,Trainer trainer){
        this.location=location;
        this.trainer=trainer;
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
        if(!location.getPokemonsToBattle().isEmpty()) {
            System.out.println("Z którym pokemonem chcesz walczyc ?");
            showPokesInLocation();
            int sc = new Scanner(System.in).nextInt();
            if(sc>0 && sc<=location.getPokemonsToBattle().size()){
                if(location.getPokemonsToBattle().get(sc-1).getStatus()== Status.Undefeated) {
                    System.out.println("Wybrales sobie do walki: " + location.getPokemonsToBattle().get(sc - 1).getName());
                    pokeBattle(location.getPokemonsToBattle().get(sc-1));
                }else {
                    System.out.println("Ten pokemon jest juz pokonany");
                }
            }else {
                System.out.println("Jebac to");
            }
        }else{
            System.out.println("W lokacji nie ma zadnego pokemona.");
        }
    }
    public void showPokesInLocation(){
        int i = 1;
        if(!location.getPokemonsToBattle().isEmpty()) {
            for (WildPokemon poke : location.getPokemonsToBattle()) {
                System.out.println(i + ". " + poke.getName() + "(" + poke.getLvl() + "): ");
                System.out.println(" -zycie: (" + poke.getHitPoint() + "/" + poke.getMaxHitPoint() + ")");
                i++;
            }
        }else{
            System.out.println("W lokacji nie ma zadnego pokemona.");
        }
    }
    public void pokeBattle(WildPokemon wildPoke){
        Battle battle = new Battle(trainer.getPokemons().get(0),wildPoke);
        System.out.println("************************************************************************************************************************");
        System.out.println(battle.letsBattle());
        System.out.println("************************************************************************************************************************");
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
