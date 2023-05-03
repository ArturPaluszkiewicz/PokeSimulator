package org.example.model;

public class PokePerks {
    private boolean active;
    private Pokemon parent;

    //Constructors
    public PokePerks(Pokemon parent){
        active = false;
        this.parent = parent;
    }
    public PokePerks(){
        active = false;
        parent = null;
    }

    //Methods
    public void activatePerks(){
        active = true;
    }
    public void deactivatePerks(){
        active = false;
    }
    private boolean checkIfParentSet(){
        if(!(parent == null)){
            return true;
        }
        return false;
    }

}
