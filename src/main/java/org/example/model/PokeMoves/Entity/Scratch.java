package org.example.model.PokeMoves.Entity;

import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;

import java.io.Serializable;

public class Scratch extends PokeMoves implements Serializable {

    public Scratch(int lvl) {
        super("Scratch", "Atak za pomoca pazurow", lvl, PokeType.Normal);
        scale();
    }

    @Override
    public int getValue() {
        return finalDamage;
    }

    @Override
    public String useMove(AbstractPokemon pokeToBuff, AbstractPokemon pokeToAttack) {
        int attack = getValue();
        int dmg = pokeToAttack.takeHit(attack);
        return ("Pokemon "+ pokeToBuff.getName() +" uzył Scratch i zadał "+ pokeToAttack.getName() +" "+ dmg +" obrazen");
    }
    @Override
    protected void scale() {
        finalDamage = addingDmg + basicDamage;
    }
}
