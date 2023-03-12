package org.example.cmdView;
import org.example.model.Trainer;
import java.util.Scanner;

public class CmdView {

    Trainer trainer;

    public void preStart(){
        boolean goNext = true;
        do{
            System.out.println("1.-Nowa Gra/2.-Kontynuluj Gre");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    trainer = new Trainer();
                    System.out.println("Twoja przygoda wlasnie sie zaczyna");
                    goNext = false;
                }
                case 2 -> {
                    try {
                        trainer = new Trainer("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Trainer");
                        System.out.println("Powracasz do swojej przygody");
                        goNext = false;
                    } catch (Exception e) {
                        System.out.println("Niestety wczytanie gry nie powiodło się ! Zacznij gre od nowa !");
                    }
                }
            }
        }while(goNext);
    }
    public void start(){
        preStart();
        while(true){
            showMenu();
            switch (new Scanner(System.in).nextInt()){
                case 1 -> {
                    new CmdLocation(trainer.getLocation(),trainer).enterLocation();
                }
                case 2 -> {
                    new ShowPokemons(trainer);
                }
                case 3 -> {
                    new GameSave(trainer);
                }
                case 4 -> {
                    new PokeExist();
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu Głowne:");
        System.out.println("Co robisz ?");
        System.out.println("1. - Wejdz do gry");
        System.out.println("2. - Wyswietl swoje pokemony");
        System.out.println("3. - Zapisz gre");
        System.out.println("4. - Wyjscie");
    }
}
