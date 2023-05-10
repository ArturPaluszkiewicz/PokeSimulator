
import org.example.model.PokeMoves.AttackMove;
import org.example.model.Pokemon;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ResourcesFilesTest {

    @Test
    public void PokemonsFileTest(){
        File pokemonDirectory = new File("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Pokemons");
        List<String> pokemonsList = Arrays.stream(pokemonDirectory.list()).toList();
        for(String pokename: pokemonsList){
            System.out.println(pokename+" git");
            Pokemon pokemon = new Pokemon(pokename);
        }
        System.out.println("koniec testu");
    }
    @Test
    public void MovesFilesTest(){
        File pokemonDirectory = new File("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\PokeMoves");
        List<String> pokeMovesList = Arrays.stream(pokemonDirectory.list()).toList();
        for(String pokeMoves: pokeMovesList){
            new AttackMove(pokeMoves);
            System.out.println(pokeMoves+" git");
        }
        System.out.println("koniec testu");
    }
}
