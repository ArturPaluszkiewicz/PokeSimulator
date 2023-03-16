import org.example.model.Battle;
import org.example.model.Moves.*;
import org.example.model.PokeType;
import org.example.model.Pokemon;
import org.example.model.Status;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BattleTest {

    Pokemon poke1 = new Pokemon();
    Pokemon poke2 = new Pokemon();
    Map<PokeMoves, Integer> pokeMoves = new HashMap<PokeMoves, Integer>();

    private void addPokeMoves(){
        pokeMoves.put(new Ember(1), 1);
        pokeMoves.put(new QuickAttack(1), 2);
        pokeMoves.put(new Scratch(1), 3);
        pokeMoves.put(new Bite(1), 4);
    }
    @Test
    public void pokemonInitiativeHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        Assert.assertEquals(90,poke1.getInitiative());
        Assert.assertEquals(90,poke2.getInitiative());
    }

    @Test
    public void pokemonAttackHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        Assert.assertEquals(10,poke1.getAttack());
        Assert.assertEquals(10,poke2.getAttack());
    }

    @Test
    public void pokemonDefenceHasNotChangedAfterBattle(){;
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        Assert.assertEquals(5,poke1.getDefence());
        Assert.assertEquals(5,poke2.getDefence());
    }
    @Test
    public void pokemonNumberOfAttackHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        Assert.assertEquals(2,poke1.getNumberOfAttack());
        Assert.assertEquals(2,poke2.getNumberOfAttack());
    }
    @Test
    public void pokemonPokeTypeHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        Assert.assertEquals(PokeType.Normal,poke1.getType());
        Assert.assertEquals(PokeType.Normal,poke2.getType());
    }
    @Test
    public void pokemonMaxHitPointHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        Assert.assertEquals(100,poke1.getMaxHitPoint());
        Assert.assertEquals(100,poke2.getMaxHitPoint());
    }

    @Test
    public void checkIsNotAllowedToBattleAlreadyDefeatedPokemon(){
        poke1.setHitPoint(0);
        Battle battle = new Battle(poke1,poke2);
        Assert.assertEquals("Twoj pokemon jest nie zdolny do Walki.",battle.letsBattle(pokeMoves));
    }

}
