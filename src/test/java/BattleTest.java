import org.example.model.Battle;
import org.example.model.PokeType;
import org.example.model.Pokemon;
import org.example.model.Status;
import org.junit.Assert;
import org.junit.Test;

public class BattleTest {

    @Test
    public void pokemonInitiativeHasNotChangedAfterBattle(){
        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal);
        Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(90,poke1.getInitiative());
        Assert.assertEquals(90,poke2.getInitiative());
    }

    @Test
    public void pokemonAttackHasNotChangedAfterBattle(){
        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal);
        Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(10,poke1.getAttack());
        Assert.assertEquals(10,poke2.getAttack());
    }

    @Test
    public void pokemonDefenceHasNotChangedAfterBattle(){
        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal);
        Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(5,poke1.getDefence());
        Assert.assertEquals(5,poke2.getDefence());
    }
    @Test
    public void pokemonNumberOfAttackHasNotChangedAfterBattle(){
        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal);
        Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(2,poke1.getNumberOfAttack());
        Assert.assertEquals(2,poke2.getNumberOfAttack());
    }
    @Test
    public void pokemonPokeTypeHasNotChangedAfterBattle(){
        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal);
        Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(PokeType.Normal,poke1.getType());
        Assert.assertEquals(PokeType.Normal,poke2.getType());
    }
    @Test
    public void pokemonMaxHitPointHasNotChangedAfterBattle(){
        Pokemon poke1 = new Pokemon("Rattata",1,100,100,5,10,90,2,10, Status.Undefeated, PokeType.Normal);
        Pokemon poke2 = new Pokemon("Rattata",1,100,100,5,10,90,2,10,Status.Undefeated,PokeType.Normal);
        Battle battle = new Battle(poke1,poke2);
        battle.letsBattle();
        Assert.assertEquals(100,poke1.getMaxHitPoint());
        Assert.assertEquals(100,poke2.getMaxHitPoint());
    }

}
