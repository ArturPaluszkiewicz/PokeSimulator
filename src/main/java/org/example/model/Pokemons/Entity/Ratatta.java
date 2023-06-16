package org.example.model.Pokemons.Entity;

import org.example.model.PokeMoves.Entity.QuickAttack;
import org.example.model.PokeMoves.Entity.Scratch;
import org.example.model.PokeMoves.PokeMoves;
import org.example.model.PokePerks.Entity.TierOne.*;
import org.example.model.Pokemons.PokeType;
import org.example.model.Pokemons.Pokemon;
import org.example.model.Pokemons.Status;

import java.io.Serializable;
import java.util.ArrayList;

public class Ratatta extends Pokemon implements Serializable {
    public Ratatta(){
        super();
        name = "Ratatta";
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
        moves.add(new QuickAttack(1));
        moves.add(new Scratch(1));
        moves.add(new QuickAttack(2));
        moves.add(new QuickAttack(3));
        moves.add(new QuickAttack(4));
        moves.add(new QuickAttack(5));
        addPerks();
    }
    private void addPerks(){
        for(int i=0;i<5;i++){
            perks.add(new PlusAttackTierOne(this));
        }
        for(int i=0;i<5;i++){
            perks.add(new PlusDefenseTierOne(this));
        }
        for(int i=0;i<5;i++){
            perks.add(new PlusSpecialAttackTierOne(this));
        }
        for(int i=0;i<10;i++){
            perks.add(new PlusSpecialDefenseTierOne(this));
        }
        perks.add(new PlusNrOfAttackTierOne(this));
    }
}
