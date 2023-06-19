package org.example.model.Pokemons;

import org.example.model.LootSystem;

import java.io.Serializable;

public class WildPokemon extends AbstractPokemon implements Serializable {

    protected LootSystem loot;

    public WildPokemon() {
        super();
        loot = new LootSystem(10);
    }
    public WildPokemon(AbstractPokemon pokemon){
        super(pokemon);
        loot = new LootSystem(10);
    }

    //getters
    public LootSystem getLoot(){return loot;}

}
