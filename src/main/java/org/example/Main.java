package org.example;
import org.example.model.*;

public class Main {
    public static void main(String[] args) {

        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        WildPokemon poke2 = new WildPokemon("Caterpie",1,90,90,4,8,80,3,10,Status.Undefeated,PokeType.Normal);

        System.out.println(new Battle(poke1,poke2).letsBattle());

        System.out.println(poke1.getHitPoint());
        System.out.println(poke2.getHitPoint());


       // new CmdView().start();
    }
}