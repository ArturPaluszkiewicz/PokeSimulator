package org.example.model.PokePerks;

import org.example.model.Pokemon;

public interface PokePerks {

    public void activatePerks(Pokemon parent);
    public void deactivatePerks(Pokemon parent);
    public boolean checkRequirements();

}
