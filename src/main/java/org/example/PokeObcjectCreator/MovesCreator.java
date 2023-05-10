package org.example.PokeObcjectCreator;

import org.example.model.*;
import org.example.model.PokeMoves.AttackFlag;
import org.example.model.PokeMoves.AttackMove;
import org.example.model.PokeMoves.ScaleFlag;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MovesCreator {

    private String name;
    private String description;
    private int lvl;
    private PokeType type;

    public void createMoves(){
        name="Quick Attack";
        description="Bardzo Szybki Atak";
        lvl=1;
        type=PokeType.Normal;
        AttackMove pokeMoves = new AttackMove(name,description,lvl,type,10,4, ScaleFlag.ARITHMETIC, AttackFlag.NORMAL);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\PokeMoves\\"+pokeMoves.getName()));
            outputStream.writeObject(pokeMoves);
            outputStream.close();
            System.out.println("Udało sie stworzyc ruch: "+pokeMoves.getName());
        } catch (Exception e) {
            System.out.println("Nie udało sie stworzyc ruch");
            e.printStackTrace();
        }
    }
}

