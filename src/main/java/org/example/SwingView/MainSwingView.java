package org.example.SwingView;


import org.example.model.Pokemons.Pokemon;
import org.example.model.Trainer;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class MainSwingView extends JFrame {

    private static MainSwingView Instance;
    public static Optional<Trainer> player = Optional.empty();
    private final JPanel centerPanel;
    private LocationFrame locationFrame;
    private MainMenuFrame mainMenuFrame;

    private MainSwingView(){
        super("Poke Simulator");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBounds(120,0,500,500);

        start();
    }
    public static MainSwingView getInstance(){
        if (Instance == null){
            Instance = new MainSwingView();
        }
        return Instance;
    }

    private void start(){
        preStart();
        setLayout(null);
        setSize(620,500);

        locationFrame = new LocationFrame(player.get().getLocation());
        mainMenuFrame = new MainMenuFrame();

        add(mainMenuFrame);
        add(centerPanel);

        repaint();
    }

    private void preStart(){
        //Function to open before start panel where Player load saved trainer from file or create new one.
         StartGameMenu startGameMenu = new StartGameMenu();
         add(startGameMenu);
         setVisible(true);
         while(true){
             repaint();
             if(player.isPresent()){
                 break;
             }
         }
         remove(startGameMenu);
         repaint();
    }
    private void removeUnusedPanels(){
       centerPanel.removeAll();
       repaint();
    }
    public void showBattleReportFrame(){
        removeUnusedPanels();
        centerPanel.add(new BattleReportFrame());
    }
    public void showLocationFrame(){
        removeUnusedPanels();
        centerPanel.add(locationFrame);
    }
    public void showTrainersFrame() {
        removeUnusedPanels();
        centerPanel.add(new TrainersFrame(player.get()));
    }
    public void showPokemonFrame(Pokemon pokemon){
        removeUnusedPanels();
        centerPanel.add(new PokemonFrame(pokemon));
    }
}
