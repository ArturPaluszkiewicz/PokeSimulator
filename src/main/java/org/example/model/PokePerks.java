package org.example.model;

public class PokePerks {
    private boolean active;
    private Pokemon parent;

    public PokePerks(){
        active = false;
    }

    public void activatePerks(){
        active = true;
    }

    public void deactivatePerks(){
        active = false;
    }

}
