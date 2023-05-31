package org.example.model.PokePerks;

import org.example.model.Pokemons.Pokemon;

public interface PokePerks {

    public void activatePerks(Pokemon parent);
    public void deactivatePerks(Pokemon parent);
    public boolean checkRequirements();

}
