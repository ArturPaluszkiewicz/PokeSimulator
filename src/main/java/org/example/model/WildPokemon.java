package org.example.model;

import org.example.model.PokeMoves.AttackMove;

import java.util.List;

public class WildPokemon extends AbstractPokemon{

    public WildPokemon() {
        super();
    }
    public WildPokemon(AbstractPokemon pokemon){
        super(pokemon);
    }
    public WildPokemon(String name, int lvl, int maxHitPoint, int defence, int attack, int specjalAttack, int specjalDefense, int initiative, int numberOfAttack, int slowAfterAttack, PokeType type, List<AttackMove> moves) {
        super(name, lvl, maxHitPoint, defence, attack, specjalAttack, specjalDefense, initiative, numberOfAttack, slowAfterAttack, type,moves);
    }
}
