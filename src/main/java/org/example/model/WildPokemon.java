package org.example.model;

public class WildPokemon extends AbstractPokemon{

    public WildPokemon() {
        super();
    }
    public WildPokemon(AbstractPokemon pokemon){
        super(pokemon);
    }
    public WildPokemon(String name, int lvl, int maxHitPoint, int hitPoint, int defence, int attack, int initiative, int numberOfAttack, int slowAfterAttack, Status status, PokeType type) {
        super(name, lvl, maxHitPoint, hitPoint, defence, attack, initiative, numberOfAttack, slowAfterAttack,status, type);
    }
}
