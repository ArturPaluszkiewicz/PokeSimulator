package org.example.model.Pokemons;

import org.example.model.PokeMoves.PokeMoves;

import java.util.List;

public interface BattlePokemon {

    //Utility Method
    public boolean checkIfDefeated();
    public int takeHit(int damage);
    public int takeSpecialHit(int damage);
    public void slowAfterAttack();

    //Setters
    public void setInitiative(int initiative);
    public void setNumberOfAttack(int numberOfAttack);
    public void setHitPoint(int hitPoint);
    public void setDefence(int defence);
    public void setAttack(int attack);

    //Getters
    public String getName();
    public int getMaxHitPoint();
    public int getHitPoint();
    public int getDefence();
    public int getAttack();
    public int getSpecialAttack();
    public int getSpecialDefense();
    public int getInitiative();
    public int getNumberOfAttack();
    public int getSlowAfterAttack();
    public Status getStatus();
    public PokeType getType();
    public List<PokeMoves> getMoves();
}