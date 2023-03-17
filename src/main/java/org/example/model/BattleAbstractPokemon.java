package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BattleAbstractPokemon implements Serializable {
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

    public BattleAbstractPokemon(){
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
       // moves.add(new PokeMoves("Scratch"));
        moves.add(new PokeMoves("Quick Attack"));
       // moves.add(new PokeMoves("Bite"));
        moves.add(new PokeMoves("Super Fang"));
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
    public void setInitiative(int initiative) {
        this.initiative = initiative;
        if(this.initiative<=0){
            this.initiative=0;
        }
    }
    public void setNumberOfAttack(int numberOfAttack) {
        this.numberOfAttack = numberOfAttack;
        if(this.numberOfAttack<0){
            this.numberOfAttack=0;
        }
    }
    public void setHitPoint(int hitPoint) {
        if (hitPoint<0){
            this.hitPoint = 0;
        }else {
            this.hitPoint = hitPoint;
        }
        checkIfDefeated();
    }
    public void setDefence(int defence) {
        this.defence = defence;
        if(this.defence<=0){
            this.defence=0;
        }
    }
    public void setAttack(int attack) {
        this.attack = attack;
        if(this.attack<=attack){
            this.attack=1;
        }
    }
    public int getMaxHitPoint() {
        return maxHitPoint;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getNumberOfAttack() {
        return numberOfAttack;
    }

    public int getSlowAfterAttack() {
        return slowAfterAttack;
    }

    public Status getStatus() {
        return status;
    }

    public PokeType getType() {
        return type;
    }

    public List<PokeMoves> getMoves() {
        return moves;
    }
}
