package org.example.model.PokeMoves.Entity;

import org.example.model.PokeMoves.AttackFlag;
import org.example.model.PokeMoves.AttackMove;
import org.example.model.PokeMoves.PokeMoves;
import org.example.model.PokeMoves.ScaleFlag;
import org.example.model.Pokemons.AbstractPokemon;
import org.example.model.Pokemons.PokeType;

import java.io.Serializable;

public class QuickAttack extends PokeMoves implements Serializable {
    private int basicDamage = 10;
    private int finalDamage = 0;
    public QuickAttack(int lvl) {
        super("Quick Attack", "Bardzo szybki atak", lvl, PokeType.Normal);
        scale();
    }

    @Override
    public int getValue() {
        return finalDamage;
    }

    @Override
    public String useMove(AbstractPokemon pokeToBuff, AbstractPokemon pokeToAttack) {
        int attack = getValue()+pokeToBuff.getAttack();
        int dmg = pokeToAttack.takeHit(attack);
        return ("Pokemon "+ pokeToBuff.getName() +" uzył Quick Attack i zadał "+ pokeToAttack.getName() +" "+ dmg +" obrazen");
    }

    @Override
    protected void scale() {
        finalDamage = addingDmg + basicDamage;
    }
}
