package org.example.model.Moves;

import org.example.model.AbstractPokemon;
import org.example.model.PokeType;

public class Ember extends PokeMoves{

    public Ember(int lvl) {
        super("Ember", lvl, PokeType.Fire,10);
        scale();
    }

    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        returnMessage+=(poke1.getName()+" uzyl Ember.\n");
        returnMessage+=poke2.getName()+" otrzymał "+poke2.takeSpecialHit(valueOfMove)+" obazen\n";
        return returnMessage;
    }

    private void scale(){
        int scaleValue = 20*getLvl();
        setValueOfMove(getValueOfMove()+scaleValue);
    }
}
