package org.example.model.PokeMoves.Entity;

import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;
import org.example.model.Pokemons.Pokemon;

import java.io.Serializable;

public class Scratch extends PokeMoves implements Serializable {

    public Scratch(int lvl, Pokemon parent) {
        super("Scratch", "Atak za pomoca pazurow", lvl, PokeType.Normal, parent);
        initiative = 67;
        scale();
        finalDamage=14;
    }

    @Override
    public int getValue() {
        return finalDamage;
    }

    @Override
    public String useMove(AbstractPokemon pokeToAttack) {
        int attack = getValue();
        int dmg = pokeToAttack.takeHit(attack);
        return ("Pokemon "+ parent.getName() +" uzył Scratch i zadał "+ pokeToAttack.getName() +" "+ dmg +" obrazen\n");
    }
    @Override
    protected void scale() {
        finalDamage = addingDmg + basicDamage;
    }
}
