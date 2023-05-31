package org.example.SwingView;

import org.example.model.Battle;
import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Trainer;

import javax.swing.*;
import java.util.HashMap;
import java.util.Optional;

public class MainSwingView extends JFrame {
    public static Optional<Trainer> player = Optional.empty();
    BattleReportFrame battleReportFrame;

    public MainSwingView(){
        super("Poke Simulator");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }

    public void start(){
        preStart();
        battleReportFrame = new BattleReportFrame();
        add(battleReportFrame);
        repaint();
    }

    public void preStart(){
        //Function to open before start panel where Player load saved trainer from file or create new one.
         MainMenuFrame mainMenuFrame = new MainMenuFrame();
         add(mainMenuFrame);
         setVisible(true);
         while(true){
             repaint();
             if(player.isPresent()){
                 System.out.println("gracz w koncu zostal wybrany jpr");
                 break;
             }
         }
         System.out.println("wyszlismy z petli");
         remove(mainMenuFrame);
         repaint();
    }
}
