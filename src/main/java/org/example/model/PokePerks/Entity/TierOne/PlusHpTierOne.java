package org.example.model.PokePerks.Entity.TierOne;

import org.example.model.PokePerks.PokePerks;
import org.example.model.Pokemons.Pokemon;

import javax.swing.*;

public class PlusHpTierOne extends PokePerks {
    private final int value = 20;
    public PlusHpTierOne(Pokemon parent) {
        super(1, parent,"HP + 20");
        icon=new ImageIcon("src/main/resources/Image/HitPointTierOne.png");
    }

    @Override
    public void activatePerks() {
        if(checkRequirements()) {
            parent.increaseMaxHp(value);
            parent.subPerksPoint(1);
            isActive = true;
        }
    }

    @Override
    public void deactivatePerks() {
        parent.decreaseMaxHp(value);
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
