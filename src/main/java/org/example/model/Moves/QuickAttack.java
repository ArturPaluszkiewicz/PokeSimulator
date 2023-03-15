package org.example.model.Moves;

import org.example.model.AbstractPokemon;
import org.example.model.PokeType;

public class QuickAttack extends PokeMoves{


    public QuickAttack(String name, int lvl) {
        super(name, lvl, PokeType.Normal,5);
    }

    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        returnMessage+=(poke1.getName()+" uzyl QuickAttack.\n");
        returnMessage+=poke2.getName()+" otrzymał "+poke2.takeSpecialHit(valueOfMove)+" obazen\n";
        return returnMessage;
    }

    private void scale(){
        int scaleValue = 5*getLvl();
        setValueOfMove(getValueOfMove()+scaleValue);
    }
}
