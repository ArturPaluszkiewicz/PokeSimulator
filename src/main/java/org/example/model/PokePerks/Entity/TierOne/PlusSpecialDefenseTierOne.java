package org.example.model.PokePerks.Entity.TierOne;

import org.example.model.PokePerks.PokePerks;
import org.example.model.Pokemons.Pokemon;

import javax.swing.*;

public class PlusSpecialDefenseTierOne extends PokePerks {

    private final int value = 8;
    public PlusSpecialDefenseTierOne(Pokemon parent) {
        super(1, parent,"Obrona Specjalna + 8");
        icon=new ImageIcon("src/main/resources/Image/SpDefenseTierOne.png");
    }

    @Override
    public void activatePerks() {
        if(checkRequirements()) {
            parent.increaseSpecialDefense(value);
            parent.subPerksPoint(1);
            isActive = true;
        }
    }

    @Override
    public void deactivatePerks() {
        parent.decreaseSpecialDefense(value);
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
