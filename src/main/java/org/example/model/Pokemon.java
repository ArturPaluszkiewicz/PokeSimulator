package org.example.model;

public class Pokemon extends AbstractPokemon {

    public Pokemon(){
        super();
    }

    public Pokemon(AbstractPokemon pokemon){
        super(pokemon);
    }

    public Pokemon(String name, int lvl, int maxHitPoint, int hitPoint, int defence, int attack, int specialAttack, int specialDefense, int initiative, int numberOfAttack,int slowAfterAttack, Status status, PokeType type) {
        super(name, lvl, maxHitPoint, hitPoint, defence, attack,specialAttack,specialDefense, initiative, numberOfAttack,slowAfterAttack, status, type);
    }
}
