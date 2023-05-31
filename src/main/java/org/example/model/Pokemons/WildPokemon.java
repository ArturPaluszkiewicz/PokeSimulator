package org.example.model.Pokemons;

import org.example.model.PokeMoves.AttackMove;
import org.example.model.PokeMoves.PokeMoves;

import java.io.Serializable;
import java.util.List;

public class WildPokemon extends AbstractPokemon implements Serializable {

    public WildPokemon() {
        super();
    }
    public WildPokemon(AbstractPokemon pokemon){
        super(pokemon);
    }
    public WildPokemon(String name, int lvl, int maxHitPoint, int defence, int attack, int specjalAttack, int specjalDefense, int initiative, int numberOfAttack, int slowAfterAttack, PokeType type, List<PokeMoves> moves) {
        super(name, lvl, maxHitPoint, defence, attack, specjalAttack, specjalDefense, initiative, numberOfAttack, slowAfterAttack, type,moves);
    }
}
