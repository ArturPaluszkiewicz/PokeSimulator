package org.example.model.Moves;

import org.example.model.AbstractPokemon;

public abstract class PokeMoves {

    private String name;
    private int lvl;

    public PokeMoves(String name, int lvl) {
        this.name = name;
        setLvl(lvl);
        scale();
    }

    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2){
        return "Abstract moves";
    }

    private void scale(){

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
    public String getName(){
        return name;
    }

    public int getLvl() {
        return lvl;
    }
}
