package org.example;
import org.example.SwingView.MainSwingView;

public class Main {
    public static void main(String[] args) {

        MainSwingView.getInstance();

        /*
        To do:
        -Dodac szablon wykorzystywanych atakow w walce do obiektu pokemon - zmienic funkcje letsBattle w klasie battle zeby pobierala ten szablon.
        -zmienic wczytywanie gry zeby sprawdzalo czy istnieje plik do odczytu
        -zmienic zapis gry zeby sprawdzal przed zapisem czy istnieje juz plik do zapisu i jesli istnieje to zapytac czy na pewno chcemy go nadpisac
        -dodac mozliwosc wyboru pokemona ktorym chce sie rozpoczac walke
        -dodac mozliwosc rozpoczecia walki bez wyboru ruchow
        -dodac perki pokemonow
        -dodac loot do dzikich pokemonow
        -dodac konstruktor do lokacji pobierajacy stringa nazwe lokacji i tworzacy obiekt na podstawie pliku o takiej nazwie w folderze resource/lokation
        -dodac konstruktor do pokemonow pobierajacy stringa i inta , tworzacy obiekt z pliku o takiej nazwie w folderze resources/pokemon i o okreslonym levelu
        -dodac metode scale do klasy Moves
         */
    }
}