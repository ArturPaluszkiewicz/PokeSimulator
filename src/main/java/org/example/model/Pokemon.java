package org.example.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

public class Pokemon extends AbstractPokemon implements Serializable {

    public Pokemon(){
        super();
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
            this.moves=pokemon.getMoves();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pokemon(AbstractPokemon pokemon){
        super(pokemon);
    }

    public Pokemon(String name, int lvl, int maxHitPoint, int defence, int attack, int specialAttack, int specialDefense, int initiative, int numberOfAttack, int slowAfterAttack, PokeType type, List<PokeMoves> moves) {
        super(name, lvl, maxHitPoint, defence, attack,specialAttack,specialDefense, initiative, numberOfAttack, slowAfterAttack, type,moves);
    }
}
