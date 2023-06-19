package org.example.model.PokeMoves;

import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;
import org.example.model.Pokemons.Pokemon;

public abstract class PokeMoves {

    protected String name, description;
    protected Pokemon parent;
    protected PokeType type;
    protected int lvl, initiative;
    protected int basicDamage = 25;
    protected int addingDmg = 0;
    protected int finalDamage = 0;

    public PokeMoves(String name, String description, int lvl, PokeType type, Pokemon parent) {
        this.name=name;
        this.description=description;
        setLvl(lvl);
        this.type=type;
        this.parent = parent;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
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
    public PokeType getType(){return type;}
    public abstract int getValue();
    public abstract String useMove(AbstractPokemon pokemonToAttack);
    protected abstract void scale();
    public int getLvl() {
        return lvl;
    }

    public int getInitiative(){return initiative;};
}
