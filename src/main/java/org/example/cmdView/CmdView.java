package org.example.cmdView;
import org.example.model.Trainer;
import java.util.Scanner;

public class CmdView {

    Trainer trainer;

    public void preStart(){
        System.out.println("1.-Nowa Gra/2.-Kontynuluj Gre");
        switch (new Scanner(System.in).nextInt()){
            case 1 -> {
                trainer = new Trainer();
                System.out.println("Twoja przygoda wlasnie sie zaczyna");
            }
            case 2 -> {
                trainer = new Trainer("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Trainer");
                System.out.println("Powracasz do swojej przygody");
            }
        }
    }
    public void start(){
        preStart();
        while(true){
            showMenu();
            switch (new Scanner(System.in).nextInt()){
                case 1 -> {
                    new ShowPokemons(trainer);
                }
                case 2 -> {
                    new GameSave(trainer);
                }
                case 3 -> {
                    new PokeExist();
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("Co robisz");
        System.out.println("1. - Wyswietl swoje pokemony");
        System.out.println("2. - Zapisz gre");
        System.out.println("3. - Wyjscie");
    }
}
