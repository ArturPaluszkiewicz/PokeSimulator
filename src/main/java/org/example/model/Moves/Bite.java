package org.example.model.Moves;

import org.example.model.AbstractPokemon;
import org.example.model.PokeType;

public class Bite extends PokeMoves{

    public Bite(String name, int lvl) {
        super(name, lvl, PokeType.Dark,10);
        scale();
    }

    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        returnMessage+=(poke1.getName()+" uzyl Bite.\n");
        returnMessage+=poke2.getName()+" otrzymał "+poke2.takeSpecialHit(valueOfMove)+" obazen\n";
        return returnMessage;
    }

    private void scale(){
        int scaleValue = 20*getLvl();
        setValueOfMove(getValueOfMove()+scaleValue);
    }

}
