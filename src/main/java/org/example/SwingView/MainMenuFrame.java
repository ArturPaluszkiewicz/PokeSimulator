package org.example.SwingView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JPanel implements ActionListener {

    private JButton battleReportsButton,locationButton;
    public MainMenuFrame(){
        setLayout(null);
        setBounds(0,0,120,500);

        locationButton = new JButton("Lokacja");
        locationButton.setBounds(5,5,110,50);
        locationButton.setFocusable(false);
        locationButton.addActionListener(this);

        battleReportsButton = new JButton("Raporty");
        battleReportsButton.setBounds(5,60,110,50);
        battleReportsButton.setFocusable(false);
        battleReportsButton.addActionListener(this);

        add(battleReportsButton);
        add(locationButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==locationButton){
            MainSwingView.getInstance().showLocationFrame();
        }
        if(e.getSource()==battleReportsButton){
            MainSwingView.getInstance().showBattleReportFrame();
        }
    }
}
