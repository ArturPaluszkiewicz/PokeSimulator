package org.example.PokeObcjectCreator;

import org.example.cmdView.CmdView;

import java.awt.*;
import java.util.Scanner;

public class PokeCreatorMain {
    public static void main(String[] args) {
        PokemonCreator pc = new PokemonCreator();
        LocationCreator lc = new LocationCreator();
        ItemCreator ic = new ItemCreator();
        MovesCreator mc = new MovesCreator();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PokeCreatorJFrame();
            }
        });


        System.out.println("Witamy w creatorze PokeObiektow:");
        do{
            System.out.println("Który typ obiektu chcialbys stworzyc ?");
            System.out.println("1 - Pokemon");
            System.out.println("2 - Lokacja");
            System.out.println("3 - Przedmiot");
            System.out.println("4 - Ruch");
            System.out.println("5 - Wyjscie\n");
            switch (new Scanner(System.in).nextInt()){
                case 1 -> {
                    pc.createPoke();

                }
                case 2 -> {
                    lc.createLocation();
                }
                case 3 -> {
                    System.out.println("Narazie nie dziala , sproboj kiedy indziej\n");
                }
                case 4 -> {
                    mc.createMoves();
                }
                case 5 -> {
                    return;
                }
            }
        }while (true);
    }
}
