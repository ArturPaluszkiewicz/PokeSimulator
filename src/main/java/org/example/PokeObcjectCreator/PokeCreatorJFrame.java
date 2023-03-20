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
    JTextArea centerArea = new JTextArea();

    public PokeCreatorJFrame(){
        super("Pokemon Creator");
        JPanel leftPanel = new JPanel(new GridLayout(0,1));
        JPanel topPanel = new JPanel();
        JPanel botPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        setBounds(400,200,700,500);

        createPokemon.addActionListener(this);
        leftPanel.add(createPokemon);

        createMove.addActionListener(this);
        leftPanel.add(createMove);

        createLocation.addActionListener(this);
        leftPanel.add(createLocation);

        createItem.addActionListener(this);
        leftPanel.add(createItem);

        centerArea.setPreferredSize(new Dimension(400,400));
        centerPanel.add(centerArea);

        add(leftPanel, BorderLayout.LINE_START);
        add(topPanel, BorderLayout.PAGE_START);
        add(botPanel, BorderLayout.PAGE_END);
        add(rightPanel, BorderLayout.LINE_END);
        add(centerPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==createPokemon){
            centerArea.append("Stworzono Pokemona\n");
        }
        if(source==createMove){
            centerArea.append("Stworzono Ruch\n");
        }
        if(source==createLocation){
            centerArea.append("Stworzono Lokacje\n");
        }
        if(source==createItem){
            centerArea.append("Stworzono Przedmiot\n");
        }
    }
}
