package org.example.model.PokePerks.Entity.TierOne;

import org.example.model.PokePerks.PokePerks;
import org.example.model.Pokemons.Pokemon;

public class PlusNrOfAttackTierOne extends PokePerks {
    private final int value = 1;
    public PlusNrOfAttackTierOne(Pokemon parent) {
        super(1, parent,"Ilosc Atakow + 1");
    }

    @Override
    public void activatePerks() {
        if(checkRequirements()) {
            parent.increaseNumberOfAttack(value);
            parent.subPerksPoint(1);
            isActive = true;
        }
    }

    @Override
    public void deactivatePerks() {
        parent.decreaseNumberOfAttack(value);
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
