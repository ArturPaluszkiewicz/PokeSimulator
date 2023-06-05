package org.example.model.Pokemons;

import org.example.model.PokeMoves.AttackMove;
import org.example.model.PokeMoves.PokeMoves;
import org.example.model.PokePerks.PokePerks;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon extends AbstractPokemon implements Serializable {

    //Pokemons Perks

    protected long experience;
    protected List<PokePerks> perks;
    protected Map<Integer, PokeMoves> battleTemplate;

    //Constructors
    public Pokemon(){
        super();
        experience = 0;
        perks = new ArrayList<PokePerks>();
        battleTemplate = new HashMap<Integer,PokeMoves>();
    }
    public Pokemon(String nameUrl){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Pokemons\\"+nameUrl));
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
            this.perks = pokemon.getPerks();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Pokemon(Pokemon pokemon){
        super(pokemon);
        this.perks = pokemon.getPerks();
    }
    public Pokemon(String name, int lvl, int maxHitPoint, int defence, int attack, int specialAttack, int specialDefense, int initiative, int numberOfAttack, int slowAfterAttack, PokeType type, List<PokeMoves> moves, List<PokePerks> perks) {
        super(name, lvl, maxHitPoint, defence, attack, specialAttack, specialDefense, initiative, numberOfAttack, slowAfterAttack, type, moves);
        this.perks = perks;
    }

    //Getters
    public List<PokePerks> getPerks() {
        return perks;
    }

    public Map<Integer, PokeMoves> getBattleTemplate() {
        return battleTemplate;
    }

    public void setBattleTemplate(Map<Integer, PokeMoves> battleTemplate) {
        this.battleTemplate = battleTemplate;
    }
    public long getExperience(){
        return experience;
    }
    public void addExperience(long exp){
        if(exp>0) {
            experience += exp;
        }
    }
}
