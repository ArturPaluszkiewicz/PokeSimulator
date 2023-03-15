package org.example.model.Moves;

import org.example.model.AbstractPokemon;
import org.example.model.PokeType;

public abstract class PokeMoves {

    protected String name;
    protected int lvl;
    protected PokeType type;
    protected int valueOfMove;
    protected String returnMessage;

    public PokeMoves(String name, int lvl,PokeType type,int valueOfMove) {
        this.name = name;
        this.type=type;
        this.valueOfMove=valueOfMove;
        returnMessage="";
        setLvl(lvl);
    }

    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2){
        return "Abstract moves";
    }


    private void setLvl(int lvl){
        if(lvl>0&&lvl<10){
            this.lvl=lvl;
        } else if (lvl>10) {
            this.lvl=10;
        }else {
            this.lvl=1;
        }

    }

    public int getValueOfMove() {
        return valueOfMove;
    }

    protected void setValueOfMove(int valueOfMove) {
        this.valueOfMove = valueOfMove;
    }

    public String getName(){
        return name;
    }

    public int getLvl() {
        return lvl;
    }
}
