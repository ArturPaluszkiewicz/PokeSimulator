package org.example.model.PokePerks.Entity.TierOne;

import org.example.model.PokePerks.PokePerks;
import org.example.model.Pokemons.Pokemon;

import javax.swing.*;

public class PlusSpecialAttackTierOne extends PokePerks {

    private final int value = 8;
    public PlusSpecialAttackTierOne(Pokemon parent) {
        super(1, parent,"Atak Specjalny + 8");
        icon=new ImageIcon("src/main/resources/Image/SpAttackTierOne.png");
    }

    @Override
    public void activatePerks() {
        if(checkRequirements()) {
            parent.increaseSpecialAttack(value);
            parent.subPerksPoint(1);
            isActive = true;
        }
    }

    @Override
    public void deactivatePerks() {
        parent.decreaseSpecialAttack(value);
        parent.addPerksPoint(1);
        isActive=false;
    }

    @Override
    public boolean checkRequirements() {
        if(parent.getPerksPoints()==1){
            return true;
        }
        return false;
    }
}
