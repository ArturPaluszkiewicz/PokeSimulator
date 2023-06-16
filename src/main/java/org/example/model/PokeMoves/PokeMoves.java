package org.example.model.PokeMoves;

import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public abstract class PokeMoves {

    protected String name, description;
    protected PokeType type;
    protected int lvl;
    protected int basicDamage = 25;
    protected int addingDmg = 0;
    protected int finalDamage = 0;

    public PokeMoves(String name, String description, int lvl, PokeType type) {
        this.name=name;
        this.description=description;
        setLvl(lvl);
        this.type=type;
    }
    public PokeMoves(String urlName){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\PokeMoves\\"+urlName));
            AttackMove pokeMoves = (AttackMove) inputStream.readObject();
            name=pokeMoves.name;
            description=pokeMoves.description;
            lvl=pokeMoves.lvl;
            type=pokeMoves.type;
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public abstract String useMove(AbstractPokemon pokeToBuff, AbstractPokemon pokeToAttack);
    protected abstract void scale();
    public int getLvl() {
        return lvl;
    }
}
