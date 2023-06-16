package org.example.SwingView.PokemonDetails;

import org.example.model.PokePerks.PokePerks;
import org.example.model.Pokemons.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PerksPanel extends JPanel {
    private Pokemon pokemon;
    private JScrollPane scrollPane;
    private JPanel jPanel;
    private JLabel points;
    public PerksPanel(Pokemon pokemon){
        this.pokemon = pokemon;
        setBounds(0,0,320,300);
        setLayout(null);

        jPanel = new JPanel();
        jPanel.setBounds(0,0,320,300);
        jPanel.setLayout(null);

        showPerks();

        scrollPane = new JScrollPane(jPanel);
        scrollPane.setBounds(0,0,320,270);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        points = new JLabel("Dostepne punkty:  ("+pokemon.getPerksPoints()+")");
        points.setBounds(0,280,300,15);
        points.setHorizontalTextPosition(SwingConstants.CENTER);
        points.setHorizontalAlignment(SwingConstants.CENTER);
        paintPointsLabel();
        add(points);
    }
    private void showPerks(){
        PokePerks pokePerk;
        int temp1 = 1,temp2 = 1;
        for (int i=0;i<pokemon.getPerks().size();i++)
        {
            pokePerk = pokemon.getPerks().get(i);
            JButton perk = new JButton(pokePerk.getIcon());
            perk.setBounds(9*(temp1)+50*(temp1-1),9*temp2+50*(temp2-1),50,50);
            perk.setFocusable(false);
            perk.setToolTipText(pokePerk.getDescription());
            if(pokePerk.isActive()){
                perk.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            }
            else {
                perk.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
            PokePerks finalPokePerk = pokePerk;
            perk.addActionListener(e -> {
                    if(pokemon.getPerksPoints()>0) {
                        finalPokePerk.activatePerks();
                        perk.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    }else{
                        JOptionPane.showMessageDialog(this,"Brak dostepnych punktow","Info",JOptionPane.OK_OPTION);
                    }
                paintPointsLabel();
            });
            jPanel.add(perk);
            temp1++;
            if(temp1%6==0){
                temp1=1;
                temp2++;
            }
        }
        if(temp2 > 3) {
            jPanel.setPreferredSize(new Dimension(300, 60 * temp2));
        }else {
            jPanel.setPreferredSize(new Dimension(300, 300));
        }
    }
    public void paintPointsLabel(){
        points.setText("Dostepne punkty:  ("+pokemon.getPerksPoints()+")");
        if(pokemon.getPerksPoints()<=0){
            points.setForeground(Color.RED);
        }
        else {
            points.setForeground(new Color(44,194,0));
        }
        repaint();
    }
}
