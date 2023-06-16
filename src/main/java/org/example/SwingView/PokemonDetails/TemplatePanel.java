package org.example.SwingView.PokemonDetails;

import javax.swing.*;

public class TemplatePanel extends JPanel {

    private JLabel firstMoveLabel,secondMoveLabel,thirdMoveLabel,fourthMoveLabel;
    public TemplatePanel(){
        setLayout(null);
        setBounds(0,0,320,300);
        firstMoveLabel = new JLabel("First Move:");
        firstMoveLabel.setBounds(20,20,100,30);
        secondMoveLabel = new JLabel("Second Move:");
        thirdMoveLabel = new JLabel("Third Move:");
        fourthMoveLabel = new JLabel("Fourth Move:");
    }
}
