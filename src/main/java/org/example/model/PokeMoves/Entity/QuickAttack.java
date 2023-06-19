package org.example.model.PokeMoves.Entity;

import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;
import org.example.model.Pokemons.Pokemon;

import java.io.Serializable;

public class QuickAttack extends PokeMoves implements Serializable {
    private int basicDamage = 10;
    private int finalDamage = 0;
    public QuickAttack(int lvl, Pokemon parent) {
        super("Quick Attack", "Bardzo szybki atak", lvl, PokeType.Normal, parent);
        initiative = 120;
        scale();
    }

    @Override
    public int getValue() {
        return finalDamage;
    }

    @Override
    public String useMove(AbstractPokemon pokeToAttack) {
        int attack = getValue()+parent.getAttack();
        int dmg = pokeToAttack.takeHit(attack);
        return (parent.getName() +" uzył Quick Attack i zadał "+ pokeToAttack.getName() +" "+ dmg +" obrazen\n");
    }

    @Override
    protected void scale() {
        finalDamage = addingDmg + basicDamage;
    }
}
