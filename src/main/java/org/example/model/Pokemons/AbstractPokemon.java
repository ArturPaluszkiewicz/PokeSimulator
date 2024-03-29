package org.example.model.Pokemons;

import org.example.model.PokeMoves.MovesTemplate;
import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Trainer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractPokemon implements BattlePokemon, Serializable {

    // utility stats
    protected String name;
    protected int lvl;
    protected PokeType type;
    // battle stats
    protected int maxHitPoint, hitPoint, defence, attack, specialAttack, specialDefense, initiative, numberOfAttack, slowAfterAttack;
    protected Status status;
    // moves and perks
    protected List<PokeMoves> moves;
    protected Optional<Trainer> owner;
    protected MovesTemplate battleTemplate;

    //Constructors
    public AbstractPokemon() {
        name = "NoNamePokemon";
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
        moves = new ArrayList<PokeMoves>();
        battleTemplate = new MovesTemplate("default");
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
        this.battleTemplate = pokemon.battleTemplate;
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
        battleTemplate = new MovesTemplate("default");
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
        if(defence<damage) {
            damage = damage - defence;
        }
        else {
            damage = 1;
        }
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

    //buffAndDebuffFunction
    public void increaseAttack(int buff){
        attack=attack+buff;
    }
    public void increaseSpecialAttack(int buff){
        specialAttack=specialAttack+buff;
    }
    public void increaseDefense(int buff){
        defence=defence+buff;
    }
    public void increaseSpecialDefense(int buff){
        specialDefense=specialDefense+buff;
    }
    public void increaseNumberOfAttack(int buff){
        numberOfAttack=numberOfAttack+buff;
    }
    public void increaseMaxHp(int buff) {
        maxHitPoint=maxHitPoint+buff;
    }
    public void decreaseAttack(int debuff){
        attack=attack-debuff;
    }
    public void decreaseSpecialAttack(int debuff){
        specialAttack=specialAttack-debuff;
    }
    public void decreaseDefense(int debuff){
        defence=defence-debuff;
    }
    public void decreaseSpecialDefense(int debuff){
        specialDefense=specialDefense-debuff;
    }
    public void decreaseNumberOfAttack(int debuff){
        numberOfAttack=numberOfAttack-debuff;
    }
    public void decreaseMaxHp(int debuff){
        maxHitPoint=maxHitPoint-debuff;
    }

    //Setters
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
    public void setOwner(Trainer newOwner){
        this.owner = Optional.ofNullable(newOwner);
    }
    public void setChosenTemplate(MovesTemplate template){
        battleTemplate = template;
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
    public List<PokeMoves> getMoves() {
        return moves;
    }
    public Optional<Trainer> getOwner() {return owner;}
    public MovesTemplate getChosenTemplate(){
        return battleTemplate;
    }
}
