package org.example.cmdView;

import org.example.model.Trainer;

public class ShowPokemons {
    public ShowPokemons(Trainer trainer){
        for(int i = 0;i<trainer.getPokemons().size();i++){
            System.out.println(trainer.getPokemons().get(i).get().getName());
            System.out.println("  Lvl: "+trainer.getPokemons().get(i).get().getLvl());
            System.out.println("  Typ: "+trainer.getPokemons().get(i).get().getType());
            System.out.println("  Status: "+trainer.getPokemons().get(i).get().getStatus());
        }
    }
}
