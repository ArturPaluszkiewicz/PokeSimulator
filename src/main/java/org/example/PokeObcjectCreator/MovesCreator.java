package org.example.PokeObcjectCreator;

import org.example.model.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class MovesCreator {

    private String name;
    private String description;
    private int lvl;
    private PokeType type;
    private int valueOfAttackMove;
    private int valueOfBuffMoves;
    private int valueOfDebuffMoves;
    private PokeMovesType movesType;
    private PokeMovesScaleType pokeMovesScaleType;
    private PokeMovesBattleFlag pokeMovesBattleFlag;
    private BattleStat statToBuffOrDebuff;

    public void createMoves(){
        name="Quick Attack";
        description="Bardzo Szybki Atak";
        lvl=1;
        type=PokeType.Normal;
        valueOfAttackMove=10;
        valueOfBuffMoves=0;
        valueOfDebuffMoves=0;
        movesType=PokeMovesType.Attack;
        pokeMovesScaleType=PokeMovesScaleType.normal;
        pokeMovesBattleFlag=PokeMovesBattleFlag.NORMAL;
        statToBuffOrDebuff=BattleStat.NONE;
        PokeMoves pokeMoves = new PokeMoves(name,description,lvl,type,valueOfAttackMove,valueOfBuffMoves,valueOfDebuffMoves,movesType,pokeMovesScaleType);
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

