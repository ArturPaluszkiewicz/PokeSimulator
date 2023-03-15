package org.example.model.Moves;

import org.example.model.AbstractPokemon;
import org.example.model.PokeType;

public class SuperFang extends PokeMoves{

    public SuperFang(String name, int lvl) {
        super(name, lvl, PokeType.Normal, 5);
    }
    @Override
    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2) {
        returnMessage +=(poke1.getName()+" uzyl SuperFang.\n");
        returnMessage +=poke2.getName()+" otrzymał "+poke2.takeSpecialHit(valueOfMove)+" obrazen\n";
        return returnMessage;
    }
    private void scale(){
        int scaleValue = 25*getLvl();
        setValueOfMove(getValueOfMove()+scaleValue);
    }
}
