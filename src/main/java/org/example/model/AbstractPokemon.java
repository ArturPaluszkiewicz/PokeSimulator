package org.example.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPokemon extends BattleAbstractPokemon implements Serializable {

    protected String name;
    protected int lvl;
    public AbstractPokemon() {
        super();
        name = "Rattata";
        lvl = 1;
    }
    public AbstractPokemon(AbstractPokemon pokemon){
        this.name = pokemon.name;
        this.lvl = pokemon.lvl;
        this.maxHitPoint = pokemon.maxHitPoint;
        this.hitPoint = pokemon.hitPoint;
        this.defence = pokemon.defence;
        this.attack = pokemon.attack;
        this.specialAttack = pokemon.specialAttack;
        this.specialDefense = pokemon.specialDefense;
        this.initiative = pokemon.initiative;
        this.numberOfAttack = pokemon.numberOfAttack;
        this.slowAfterAttack = pokemon.slowAfterAttack;
        this.status = pokemon.status;
        this.type = pokemon.type;
        this.moves = pokemon.moves;
    }

    public AbstractPokemon(String name, int lvl, int maxHitPoint, int defence, int attack,int specialAttack,int specialDefense, int initiative, int numberOfAttack, int slowAfterAttack, PokeType type,List<PokeMoves> moves) {
        this.name = name;
        this.lvl = lvl;
        this.maxHitPoint = maxHitPoint;
        this.hitPoint = maxHitPoint;
        this.defence = defence;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.initiative = initiative;
        this.numberOfAttack = numberOfAttack;
        this.slowAfterAttack = slowAfterAttack;
        this.status = Status.Undefeated;
        this.type = type;
        this.moves = moves;
    }

    public AbstractPokemon(String urlName){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Pokemons\\"+urlName));
            Pokemon pokemon = (Pokemon)inputStream.readObject();
            this.name = pokemon.name;
            this.lvl = pokemon.lvl;
            this.maxHitPoint = pokemon.maxHitPoint;
            this.hitPoint = pokemon.hitPoint;
            this.defence = pokemon.defence;
            this.attack = pokemon.attack;
            this.specialAttack = pokemon.specialAttack;
            this.specialDefense = pokemon.specialDefense;
            this.initiative = pokemon.initiative;
            this.numberOfAttack = pokemon.numberOfAttack;
            this.slowAfterAttack = pokemon.slowAfterAttack;
            this.status = pokemon.status;
            this.type = pokemon.type;
            this.moves=pokemon.getMoves();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getName() {
        return name;
    }
    public int getLvl() {
        return lvl;
    }
}
