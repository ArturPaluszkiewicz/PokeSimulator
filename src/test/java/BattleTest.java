import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BattleTest {

    Pokemon poke1 = new Pokemon();
    Pokemon poke2 = new Pokemon();
    Map<Integer, PokeMoves> pokeMoves = new HashMap<Integer, PokeMoves>();

    private void addPokeMoves(){
        pokeMoves.put(1, new PokeMoves("Ember"));
        pokeMoves.put(2, new PokeMoves("QuickAttack"));
        pokeMoves.put(3, new PokeMoves("Scratch"));
        pokeMoves.put(4, new PokeMoves("Bite"));
    }
    @Test
    public void pokemonStatisticHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle(pokeMoves);
        //Initiative
        Assert.assertEquals(90,poke1.getInitiative());
        Assert.assertEquals(90,poke2.getInitiative());
        //Attack
        Assert.assertEquals(10,poke1.getAttack());
        Assert.assertEquals(10,poke2.getAttack());
        //Defense
        Assert.assertEquals(5,poke1.getDefence());
        Assert.assertEquals(5,poke2.getDefence());
        //NumberOfAttack
        Assert.assertEquals(2,poke1.getNumberOfAttack());
        Assert.assertEquals(2,poke2.getNumberOfAttack());
        //SpecialAttack
        Assert.assertEquals(30,poke1.getSpecialAttack());
        Assert.assertEquals(30,poke2.getSpecialAttack());
        //SpecialDefense
        Assert.assertEquals(20, poke1.getSpecialDefense());
        Assert.assertEquals(20, poke2.getSpecialDefense());
        //SlowAfterAttack
        Assert.assertEquals(10, poke1.getSlowAfterAttack());
        Assert.assertEquals(10,poke2.getSlowAfterAttack());
        //PokeType
        Assert.assertEquals(PokeType.Normal,poke1.getType());
        Assert.assertEquals(PokeType.Normal,poke2.getType());
        //MaxHitPoints
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
