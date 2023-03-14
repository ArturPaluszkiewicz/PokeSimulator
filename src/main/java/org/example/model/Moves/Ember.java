package org.example.model.Moves;

import org.example.model.AbstractPokemon;

public class Ember extends PokeMoves{

    private int emberDmg;
    public Ember(String name, int lvl) {
        super(name, lvl);
        emberDmg = 30;
    }

    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        return "Wrogi pokemon otrzymał "+poke2.takeHit(emberDmg)+" obazen";
    }
}
