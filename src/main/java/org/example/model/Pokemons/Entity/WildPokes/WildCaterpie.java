package org.example.model.Pokemons.Entity.WildPokes;

import org.example.model.PokeMoves.Entity.QuickAttack;
import org.example.model.PokeMoves.Entity.Scratch;
import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.PokeType;
import org.example.model.Pokemons.Status;
import org.example.model.Pokemons.WildPokemon;

import java.io.Serializable;
import java.util.ArrayList;

public class WildCaterpie extends WildPokemon implements Serializable {

    public WildCaterpie(int lvl){
        super();
        name = "Caterpie";
        this.lvl = lvl;
        type = PokeType.Bug;
        maxHitPoint = 80;
        hitPoint = 80;
        defence = 5;
        attack = 8;
        specialAttack = 35;
        specialDefense = 25;
        initiative = 90;
        numberOfAttack = 2;
        slowAfterAttack = 10;
        status = Status.Undefeated;
        moves = new ArrayList<PokeMoves>();
    }
}
