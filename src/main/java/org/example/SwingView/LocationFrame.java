package org.example.SwingView;

import org.example.model.Locations.Location;

import javax.swing.*;
import java.awt.*;

public class LocationFrame extends JPanel{

    private final Location location;
    private final JScrollPane scrollPane;
    private final JPanel jPanel;
    private int numberOfButtons;
    public LocationFrame(Location location){
        this.location = location;
        numberOfButtons = 0;
        setBounds(0,0,500,500);

        jPanel = new JPanel();
        jPanel.setLayout(null);

        int temp1=1;
        int temp2=1;

        for (int i = 1;i<=location.getPokemonsToBattle().size();i++){
            numberOfButtons++;
            BattleFrame tempButton = new BattleFrame(location.getPokemonsToBattle().get(i-1));
            tempButton.setBounds(3*temp1+150*(temp1-1),3*(temp2)+150*(temp2-1),150,150);
            jPanel.add(tempButton);
            temp1++;
            if(i%3==0){
                temp1=1;
                temp2++;
            }
        }
        jPanel.setPreferredSize(new Dimension(480,temp2*156));

        scrollPane = new JScrollPane(jPanel);
        scrollPane.setBounds(0,0,480,480);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        setVisible(true);
    }
}
