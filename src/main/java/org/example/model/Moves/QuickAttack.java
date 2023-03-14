package org.example.model.Moves;

import org.example.model.AbstractPokemon;

public class QuickAttack extends PokeMoves{

    private int quickAttackDmg;
    public QuickAttack(String name, int lvl) {
        super(name, lvl);
        quickAttackDmg = 10;
    }

    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        return "Wrogi pokemon otrzymał "+poke2.takeHit(quickAttackDmg)+" obazen";
    }
}
