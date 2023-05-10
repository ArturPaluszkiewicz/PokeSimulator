package org.example.model.PokeMoves;


import org.example.model.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class AttackMove extends PokeMoves implements Serializable {

    private int basicDamage, scaleValue, finalDamage;
    private ScaleFlag scaleFlag;
    private AttackFlag attackFlag;

    // Constructors
    public AttackMove(String name, String description, int lvl, PokeType type, int basicDamage, int scaleValue, ScaleFlag scaleFlag, AttackFlag attackFlag) {
        super(name,description,lvl,type);
        this.basicDamage = basicDamage;
        this.scaleValue = scaleValue;
        this.scaleFlag = scaleFlag;
        this.attackFlag = attackFlag;
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
        if(attackFlag==AttackFlag.NORMAL){
            int attack = getValue()+pokeToBuff.getAttack();
            dmg = pokeToAttack.takeHit(attack);
        }
        return ("Pokemon "+ pokeToBuff.getName() +" zaatakowal "+ pokeToAttack.getName() +" za "+ dmg +" ilosc obrazen");
    }
    @Override
    protected void scale() {
        finalDamage = basicDamage+(lvl*lvl*scaleValue);
    }
    @Override
    public int getValue() {
        scale();
        return finalDamage;
    }
}
