package org.example.model.PokeMoves;


import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class AttackMove extends PokeMoves implements Serializable {

    private int basicDamage, finalDamage;

    // Constructors
    public AttackMove(String name, String description, int lvl, PokeType type, int basicDamage) {
        super(name,description,lvl,type);
        this.basicDamage = basicDamage;
    } // Basic Constructor
    public AttackMove(String urlName){
        super(urlName);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\PokeMoves\\"+urlName));
            AttackMove pokeMoves = (AttackMove) inputStream.readObject();
            this.basicDamage = pokeMoves.basicDamage;
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Read from File Constructor

    //Methods
    //Override Methods
    @Override
    public String useMove(AbstractPokemon pokeToBuff, AbstractPokemon pokeToAttack) {
        int dmg=0;
        if(true){
            int attack = getValue()+pokeToBuff.getAttack();
            dmg = pokeToAttack.takeHit(attack);
        }
        return ("Pokemon "+ pokeToBuff.getName() +" zaatakowal "+ pokeToAttack.getName() +" za "+ dmg +" ilosc obrazen");
    }
    @Override
    protected void scale() {
        finalDamage = basicDamage+(lvl*lvl);
    }
    @Override
    public int getValue() {
        scale();
        return finalDamage;
    }
}
