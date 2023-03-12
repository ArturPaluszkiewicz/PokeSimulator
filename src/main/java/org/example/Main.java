package org.example;
import org.example.cmdView.CmdView;
import org.example.model.*;

public class Main {
    public static void main(String[] args) {

       // Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
       // WildPokemon poke2 = new WildPokemon("Caterpie",1,90,90,4,8,80,3,10,Status.Undefeated,PokeType.Normal);

        new CmdView().start();




        /*
        To do:
        -zmienic wczytywanie gry zeby sprawdzalo czy istnieje plik do odczytu
        -zmienic zapis gry zeby sprawdzal przed zapisem czy istnieje juz plik do zapisu i jesli istnieje to zapytac czy na pewno chcemy go nadpisac
        -dodac mozliwosc wyboru pokemona ktorym chce sie rozpoczac walke
         */
    }
}