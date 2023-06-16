package org.example.SwingView.PokemonDetails;

import org.example.model.PokeMoves.PokeMoves;
import org.example.model.Pokemons.PokeType;
import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;

public class MovesPanel extends JPanel {
    Pokemon pokemon;
    public MovesPanel(Pokemon pokemon){
        this.pokemon = pokemon;
        setBounds(0,0,320,300);
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        showMoves();
    }
    private void showMoves(){
        PokeMoves pokeMove;
        int temp1 = 1,temp2 = 1;
        for (int i=0;i<pokemon.getMoves().size();i++)
        {
            pokeMove = pokemon.getMoves().get(i);
            JButton move = new JButton(String.valueOf(pokeMove.getName().charAt(0)));
            move.setBounds(11*(temp1)+50*(temp1-1),11*temp2+50*(temp2-1),50,50);
            move.setFocusable(false);
            move.setToolTipText(pokeMove.getName());
            setButtonMoveColor(pokeMove,move);
            PokeMoves finalPokeMove = pokeMove;
            move.addActionListener(e -> {
                showMoveDetail(finalPokeMove);
            });
            add(move);
            temp1++;
            if(temp1%6==0){
                temp1=1;
                temp2++;
            }
        }
    }

    private void showMoveDetail(PokeMoves pokeMove){
        JTextArea moveText = new JTextArea(setMoveDetailText(pokeMove));
        moveText.setEditable(false);
        moveText.setFocusable(false);
        moveText.setFont(new Font("Arial",Font.BOLD,13));
        moveText.setBounds(0,0,320,250);
        moveText.setBorder(BorderFactory.createLineBorder(Color.black));
        moveText.setLineWrap(true);

        JButton back = new JButton("Powrot");
        back.setFocusable(false);
        back.setBounds(110,260,100,30);
        back.addActionListener(e -> {
            removeAll();
            showMoves();
            repaint();
        });
        removeAll();
        add(moveText);
        add(back);
        repaint();
    }
    private void setButtonMoveColor(PokeMoves pokeMoves,JButton move) {
        if(pokeMoves.getType().equals(PokeType.Normal)){
            move.setBackground(new Color(255,153,204));
        } else if (pokeMoves.getType().equals(PokeType.Grass)) {
            move.setBackground(new Color(0,153,0));
        } else if (pokeMoves.getType().equals(PokeType.Earth)) {
            move.setBackground(new Color(153,76,0));
        } else if (pokeMoves.getType().equals(PokeType.Bug)) {
            move.setBackground(new Color(178,255,102));
        } else if (pokeMoves.getType().equals(PokeType.Electric)) {
            move.setBackground(new Color(255,255,51));
        } else move.setBackground(Color.GRAY);
    }
    private String setMoveDetailText(PokeMoves move){

        return new StringBuilder()
                .append("Nazwa: "+move.getName())
                .append("\nLvl: "+move.getLvl())
                .append("\nOpis: "+move.getDescription())
                .append("\nTyp: "+move.getType())
                .append("\nObrazenia: "+move.getValue())
                .toString();
    }
}

