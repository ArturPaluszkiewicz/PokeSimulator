package org.example.PokeObcjectCreator;

import javax.swing.*;
import java.awt.*;

public class MovesCreatorJPanel extends JPanel {

    JLabel name = new JLabel("Nazwa:");
    JLabel description = new JLabel("Opis:");
    JLabel lvl = new JLabel("Lvl:");
    JLabel type = new JLabel("Typ:");
    JLabel valueOfAttackMove = new JLabel("Obrazenia:");
    JLabel valueOfBuffMove = new JLabel("Wartosc wzmocnienia:");
    JLabel valueOfDeBuffMove = new JLabel("Wartosc oslabienia:");
    JLabel movesType = new JLabel("Typ ruchu:");
    JLabel pokeMovesScaleFlag = new JLabel("Flaga scalowania ruchu");
    JLabel pokeMovesBattleFlag = new JLabel("Flaga Walki:");
    JLabel statToBuffOrDebuff = new JLabel("Statystyka od buffowania:");

    public MovesCreatorJPanel() {
        setLayout(null);
        name.setBounds(10,10,200,50);
        name.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        name.setHorizontalAlignment(JLabel.RIGHT);
        add(name);

        description.setBounds(10,70,200,50);
        description.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        description.setHorizontalAlignment(JLabel.RIGHT);
        add(description);

        lvl.setBounds(10,130,200,50);
        lvl.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        lvl.setHorizontalAlignment(JLabel.RIGHT);
        add(lvl);

        type.setBounds(10,190,200,50);
        type.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        type.setHorizontalAlignment(JLabel.RIGHT);
        add(type);

        valueOfAttackMove.setBounds(10,250,200,50);
        valueOfAttackMove.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        valueOfAttackMove.setHorizontalAlignment(JLabel.RIGHT);
        add(valueOfAttackMove);

        valueOfBuffMove.setBounds(10,310,200,50);
        valueOfBuffMove.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        valueOfBuffMove.setHorizontalAlignment(JLabel.RIGHT);
        add(valueOfBuffMove);

        valueOfDeBuffMove.setBounds(10,370,200,50);
        valueOfDeBuffMove.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        valueOfDeBuffMove.setHorizontalAlignment(JLabel.RIGHT);
        add(valueOfDeBuffMove);

        movesType.setBounds(10,430,200,50);
        movesType.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        movesType.setHorizontalAlignment(JLabel.RIGHT);
        add(movesType);

        pokeMovesScaleFlag.setBounds(10,490,200,50);
        pokeMovesScaleFlag.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        pokeMovesScaleFlag.setHorizontalAlignment(JLabel.RIGHT);
        add(pokeMovesScaleFlag);

        pokeMovesBattleFlag.setBounds(10,550,200,50);
        pokeMovesBattleFlag.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        pokeMovesBattleFlag.setHorizontalAlignment(JLabel.RIGHT);
        add(pokeMovesBattleFlag);

        statToBuffOrDebuff.setBounds(10,610,200,50);
        statToBuffOrDebuff.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        statToBuffOrDebuff.setHorizontalAlignment(JLabel.RIGHT);
        add(statToBuffOrDebuff);
    }



}
