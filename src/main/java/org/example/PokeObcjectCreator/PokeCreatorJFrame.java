package org.example.PokeObcjectCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokeCreatorJFrame extends JFrame implements ActionListener {

    JButton createPokemon = new JButton("Stworz Pokemona");
    JButton createMove = new JButton("Stworz Ruch");
    JButton createLocation = new JButton("Stworz Lokacje");
    JButton createItem = new JButton("Stworz Item");

    JLabel menu = new JLabel("Menu");

    JPanel leftPanel = new JPanel();
    JPanel verticalBorder = new JPanel();
    JPanel horizontalBorder = new JPanel();
    JPanel rightPanel = new JPanel();

    MovesCreatorJPanel mCJPanel = new MovesCreatorJPanel();

    public PokeCreatorJFrame(){
        super("Pokemon Creator");
        setBounds(220,30,1400,1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        leftPanel.setBounds(0,0,250,961);
        leftPanel.setLayout(null);

        verticalBorder.setBounds(250,0,20,961);
        verticalBorder.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        verticalBorder.setBackground(Color.DARK_GRAY);

        horizontalBorder.setBounds(268,60,1130,20);
        horizontalBorder.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        horizontalBorder.setBackground(Color.DARK_GRAY);

        rightPanel.setBounds(270,0,1150,961);

        mCJPanel.setBounds(270,80,1130,961);

        menu.setBounds(0,60,254,20);
        menu.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        menu.setHorizontalAlignment(JLabel.CENTER);
        menu.setBackground(Color.DARK_GRAY);
        menu.setOpaque(true);
        menu.setForeground(Color.WHITE);

        createPokemon.setBounds(10,100,230,100);
        createPokemon.addActionListener(this);

        createMove.setBounds(10,210,230,100);
        createMove.addActionListener(this);

        createLocation.setBounds(10,320,230,100);
        createLocation.addActionListener(this);

        createItem.setBounds(10,430,230,100);
        createItem.addActionListener(this);

       // add(rightPanel);
        add(horizontalBorder);
        add(verticalBorder);
        add(leftPanel);
        add(mCJPanel);
        leftPanel.add(menu);
        leftPanel.add(createPokemon);
        leftPanel.add(createMove);
        leftPanel.add(createLocation);
        leftPanel.add(createItem);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==createPokemon){
           // new PokemonCreator().createPoke();
            mCJPanel.setVisible(false);
        }
        if(source==createMove){
          //  new MovesCreator().createMoves();
            mCJPanel.setVisible(true);
            moveCreatorPanel();
        }
        if(source==createLocation){
           // new LocationCreator().createLocation();
            mCJPanel.setVisible(false);
        }
        if(source==createItem){
            mCJPanel.setVisible(false);
        }
    }

    void pokemonCreatorPanel(){

    }
    void moveCreatorPanel(){
    }
}