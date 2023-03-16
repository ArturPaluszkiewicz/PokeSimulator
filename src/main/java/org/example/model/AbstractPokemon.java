package org.example.model;

import org.example.model.Moves.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPokemon implements Serializable {

    protected String name;
    protected int lvl;
    protected int maxHitPoint;
    protected int hitPoint;
    protected int defence;
    protected int attack;
    protected int specialAttack;
    protected int specialDefense;
    protected int initiative;
    protected int numberOfAttack;
    protected int slowAfterAttack;
    protected Status status;
    protected PokeType type;
    protected List<PokeMoves> moves;

    public AbstractPokemon() {
        name = "Rattata";
        lvl = 1;
        maxHitPoint = 100;
        hitPoint = 100;
        defence = 5;
        attack = 10;
        specialAttack = 30;
        specialDefense = 20;
        initiative = 90;
        numberOfAttack = 2;
        slowAfterAttack = 10;
        status = Status.Undefeated;
        type = PokeType.Normal;
        moves = new ArrayList<PokeMoves>();
        moves.add(new Scratch(1));
        moves.add(new QuickAttack(1));
        moves.add(new Bite(1));
        moves.add(new SuperFang(1));
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
    }

    public AbstractPokemon(String name, int lvl, int maxHitPoint, int hitPoint, int defence, int attack,int specialAttack,int specialDefense, int initiative, int numberOfAttack, int slowAfterAttack, Status status, PokeType type,List<PokeMoves> moves) {
        this.name = name;
        this.lvl = lvl;
        this.maxHitPoint = maxHitPoint;
        this.hitPoint = hitPoint;
        this.defence = defence;
        this.attack = attack;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.initiative = initiative;
        this.numberOfAttack = numberOfAttack;
        this.slowAfterAttack = slowAfterAttack;
        this.status = status;
        this.type = type;
        this.moves=moves;
    }

    public AbstractPokemon(String url){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(url));
            Pokemon pokemon = (Pokemon)inputStream.readObject();
            inputStream.close();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfDefeated(){
        if(hitPoint<=0){
            status = Status.Defeated;
            return true;
        }
        return false;
    }

    public int takeHit(int damage){
        damage -= defence;
        setHitPoint(hitPoint-damage);
        return damage;
    }
    public int takeSpecialHit(int damage){
        damage -= specialDefense;
        setHitPoint(hitPoint-damage);
        return damage;
    }
    public void slowAfterAttack(){
        setInitiative(initiative-slowAfterAttack);
        setNumberOfAttack(numberOfAttack-1);
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getMaxHitPoint(){
        return maxHitPoint;
    }
    protected void setMaxHitPoint(int maxHitPoint){
        this.maxHitPoint=maxHitPoint;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        if (hitPoint<0){
            this.hitPoint = 0;
        }else {
            this.hitPoint = hitPoint;
        }
        checkIfDefeated();
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
        if(this.defence<=0){
            this.defence=0;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
        if(this.attack<=attack){
            this.attack=1;
        }
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
        if(this.initiative<=0){
            this.initiative=0;
        }
    }

    public int getNumberOfAttack() {
        return numberOfAttack;
    }

    public void setNumberOfAttack(int numberOfAttack) {
        this.numberOfAttack = numberOfAttack;
        if(this.numberOfAttack<0){
            this.numberOfAttack=0;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PokeType getType() {
        return type;
    }

    public List<PokeMoves> getMoves() {
        return moves;
    }
}
