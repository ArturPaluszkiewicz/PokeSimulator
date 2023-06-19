package org.example.model.Battle;

import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.Pokemon;
import org.example.model.Pokemons.WildPokemon;

import java.util.Optional;

public class QueueEntity implements Comparable<QueueEntity> {
    private int initiative;
    private int attacksLeft;  //number of attack left in round , when 0 entity should be removed from queue;
    private final PokemonOrMove type;
    private final Team team;
    private final Optional<Pokemon> pokemon; //pokemons that use attack
    private final Optional<PokeMoves> move; //move to use if pokemon is empty
    private final Optional<WildPokemon> wildPokemon; //wild pokemon that use attack


    //constructors (one for Pokemon and one for Move)

    public QueueEntity(Pokemon pokemon,Team team){
        this.pokemon = Optional.ofNullable(pokemon);
        this.team = team;
        move = Optional.empty();
        wildPokemon = Optional.empty();
        initiative = pokemon.getInitiative();
        attacksLeft = pokemon.getNumberOfAttack();
        type = PokemonOrMove.POKEMON;
    }
    public QueueEntity(PokeMoves move, Team team){
        this.move = Optional.ofNullable(move);
        this.team = team;
        pokemon = Optional.empty();
        wildPokemon = Optional.empty();
        initiative = move.getInitiative();
        attacksLeft = 1;
        type = PokemonOrMove.MOVE;
    }
    public QueueEntity(WildPokemon wildPokemon, Team team){
        this.wildPokemon = Optional.ofNullable(wildPokemon);
        this.team = team;
        move = Optional.empty();
        pokemon = Optional.empty();
        initiative = wildPokemon.getInitiative();
        attacksLeft = wildPokemon.getNumberOfAttack();
        type = PokemonOrMove.WILD_POKEMON;
    }
    // methods
    public int useMoveOrAttack(){
        //functions to decrease attackLeft and initiative after pokemon attack or move was used;
        attacksLeft=attacksLeft-1;
        if(type==PokemonOrMove.POKEMON){
            initiative = initiative-pokemon.get().getSlowAfterAttack();
        }
        if(type==PokemonOrMove.WILD_POKEMON){
            initiative = initiative-wildPokemon.get().getSlowAfterAttack();
        }
        return attacksLeft;
    }
    // getters
    public PokemonOrMove getType(){return type;}
    public int getInitiative(){return initiative;}
    public int getAttacksLeft(){return attacksLeft;}
    public Optional<Pokemon> getPokemon(){return pokemon;}
    public Optional<WildPokemon> getWildPokemon(){return wildPokemon;};
    public Optional<PokeMoves> getMove(){return move;}
    public Team getTeam(){return team;}

    @Override
    public int compareTo(QueueEntity otherQueueEntity) {
        return Integer.compare(getInitiative(),otherQueueEntity.getInitiative());
    }

    public enum PokemonOrMove{
        MOVE,POKEMON,WILD_POKEMON;
    }
    public enum Team{
        TEAM_A,TEAM_B
    }
}
