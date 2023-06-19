package org.example.model.PokePerks;

import org.example.model.LootSystem;
import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.Pokemon;
import org.example.model.Pokemons.WildPokemon;

public class NewBattle {

    private final int maxRound = 10;
    private final Pokemon pokemon;
    private final WildPokemon wildPokemon;
    private AbstractPokemon pokemonCopy, wildPokemonCopy;
    private StringBuilder report;
    private final LootSystem loot;

    public NewBattle(Pokemon pokemon , WildPokemon wildPokemon){
        this.pokemon = pokemon;
        this.wildPokemon = wildPokemon;
        loot = wildPokemon.getLoot();
        copyPokemons();
        report = new StringBuilder();
    }
    public String letsBattle(){
        beforeBattleStarts();

        return report.toString();
    }

    private void copyPokemons(){
        pokemonCopy = new Pokemon(pokemon);
        wildPokemonCopy = new WildPokemon(wildPokemon);
    }
    private void beforeBattleStarts(){
        report.append("Rozpoczela sie walka pomiedzy "+pokemon.getName()+" a dzikim "+wildPokemon.getName());
    }
}
