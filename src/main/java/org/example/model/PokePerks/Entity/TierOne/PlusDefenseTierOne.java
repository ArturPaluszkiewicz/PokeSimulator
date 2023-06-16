package org.example.model.PokePerks.Entity.TierOne;

import org.example.model.PokePerks.PokePerks;
import org.example.model.Pokemons.Pokemon;

import javax.swing.*;

public class PlusDefenseTierOne extends PokePerks {
    private final int value = 2;
    public PlusDefenseTierOne(Pokemon parent) {
        super(1, parent,"Defense + 2");
        icon=new ImageIcon("src/main/resources/Image/DefenseTierOne.png");
    }

    @Override
    public void activatePerks() {
        if(checkRequirements()) {
            parent.increaseDefense(value);
            parent.subPerksPoint(1);
            isActive = true;
        }
    }

    @Override
    public void deactivatePerks() {
        parent.decreaseDefense(value);
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
