package org.example.model;

import org.example.model.PokeMoves.AttackMove;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPokemon implements BattlePokemon, Serializable {

    // utility stats
    protected String name;
    protected int lvl;
    protected PokeType type;
    // battle stats
    protected int maxHitPoint, hitPoint, defence, attack, specialAttack, specialDefense, initiative, numberOfAttack, slowAfterAttack;
    protected Status status;
    // moves and perks
    protected List<AttackMove> moves;

    //Constructors
    public AbstractPokemon() {
        name = "Rattata";
        lvl = 1;
        type = PokeType.Normal;
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
        moves = new ArrayList<AttackMove>();
        // moves.add(new PokeMoves("Scratch"));
        moves.add(new AttackMove("Quick Attack"));
        // moves.add(new PokeMoves("Bite"));
        moves.add(new AttackMove("Super Fang"));
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
        this.moves = pokemon.getMoves();
    }
    public AbstractPokemon(String name, int lvl, int maxHitPoint, int defence, int attack,int specialAttack,int specialDefense, int initiative, int numberOfAttack, int slowAfterAttack, PokeType type,List<AttackMove> moves) {
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
            this.moves = pokemon.getMoves();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Methods
    public String getName() {
        return name;
    }
    public int getLvl() {
        return lvl;
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
        if(this.attack<=0){
            this.attack=1;
        }
    }

    // Getters
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
    public List<AttackMove> getMoves() {
        return moves;
    }
}
