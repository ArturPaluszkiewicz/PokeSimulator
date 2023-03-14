import org.example.model.Battle;
import org.example.model.PokeType;
import org.example.model.Pokemon;
import org.example.model.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleTest {

    Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,30,20,90,2,10, Status.Undefeated, PokeType.Normal);
    Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,30,20,90,2,10,Status.Undefeated,PokeType.Normal);
    @Test
    public void pokemonInitiativeHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(90,poke1.getInitiative());
        Assert.assertEquals(90,poke2.getInitiative());
    }

    @Test
    public void pokemonAttackHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(10,poke1.getAttack());
        Assert.assertEquals(10,poke2.getAttack());
    }

    @Test
    public void pokemonDefenceHasNotChangedAfterBattle(){;
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(5,poke1.getDefence());
        Assert.assertEquals(5,poke2.getDefence());
    }
    @Test
    public void pokemonNumberOfAttackHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(2,poke1.getNumberOfAttack());
        Assert.assertEquals(2,poke2.getNumberOfAttack());
    }
    @Test
    public void pokemonPokeTypeHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(PokeType.Normal,poke1.getType());
        Assert.assertEquals(PokeType.Normal,poke2.getType());
    }
    @Test
    public void pokemonMaxHitPointHasNotChangedAfterBattle(){
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(100,poke1.getMaxHitPoint());
        Assert.assertEquals(100,poke2.getMaxHitPoint());
    }

    @Test
    public void checkIsNotAllowedToBattleAlreadyDefeatedPokemon(){
        poke1.setHitPoint(0);
        Battle battle = new Battle(poke1,poke2);
        Assert.assertEquals("Twoj pokemon jest nie zdolny do Walki.",battle.letsBattle());
    }

}
