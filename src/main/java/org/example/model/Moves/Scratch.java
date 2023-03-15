package org.example.model.Moves;

import org.example.model.AbstractPokemon;
import org.example.model.PokeType;

public class Scratch extends PokeMoves{
    public Scratch(String name, int lvl) {
        super(name, lvl,PokeType.Normal,10);
    }

    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        returnMessage+=(poke1.getName()+" uzyl Scratch.\n");
        returnMessage+=poke2.getName()+" otrzymał "+poke2.takeSpecialHit(valueOfMove)+" obazen\n";
        return returnMessage;
    }
    private void scale(){
        int scaleValue = 20*getLvl();
        setValueOfMove(getValueOfMove()+scaleValue);
    }


}
