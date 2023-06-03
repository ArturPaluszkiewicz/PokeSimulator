package org.example.SwingView;

import org.example.model.Trainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Optional;

public class StartGameMenu extends JPanel implements ActionListener {
    JButton newGame;
    JButton loadGame;
    public StartGameMenu(){
        newGame = new JButton("New Game");
        newGame.setBounds(150,150,200,50);
        newGame.addActionListener(this);
        newGame.setFocusable(false);


        loadGame = new JButton("Load Game");
        loadGame.setBounds(150, 210,200,50);
        loadGame.addActionListener(this);
        loadGame.setFocusable(false);

        add(newGame);
        add(loadGame);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newGame){
            MainSwingView.player = Optional.of(new Trainer());
        }
        if(e.getSource()==loadGame){
            try {
                MainSwingView.player = Optional.of(new Trainer("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\Trainer"));
            } catch (FileNotFoundException ex) {
                MainSwingView.player = Optional.empty();
            }
        }
    }
}