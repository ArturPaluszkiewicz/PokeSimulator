package org.example.model.PokePerks;

import org.example.model.Pokemons.Pokemon;

import javax.swing.*;

public abstract class PokePerks {

    protected int tier;
    protected boolean isActive;
    protected Pokemon parent;
    protected String description;
    protected ImageIcon icon;

    public PokePerks(int tier, Pokemon parent,String description){
        this.parent = parent;
        this.tier = tier;
        this.description=description;
        icon=new ImageIcon("src/main/resources/Image/DefaultTierOne.png");
        isActive=false;
    }
    public abstract void activatePerks();
    public abstract void deactivatePerks();
    public abstract boolean checkRequirements();
    public int getTier(){return tier;}
    public String getDescription(){return description;}
    public ImageIcon getIcon(){return icon;}
    public boolean isActive(){return isActive;}
}
