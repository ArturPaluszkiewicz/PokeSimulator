package org.example.SwingView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class BattleReportFrame extends JPanel implements ActionListener {

    private final String filePath = "C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\BattleReports";
    private JTextArea reportText;
    private JLabel emptyLabel;
    private JComboBox comboBox;
    private JScrollPane scrollPane;

    public BattleReportFrame(){
        setBounds(0,0,500,500);
        setLayout(null);

        reportText = new JTextArea("Wybierz raport do wsywietlenia");
        reportText.setFocusable(false);
        reportText.setLineWrap(true);
        reportText.setFont(new Font("Arial",Font.PLAIN,12));
        reportText.setEditable(false);

        scrollPane = new JScrollPane(reportText);
        scrollPane.setBounds(40,40,400,400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        addReportsButtons();
        add(scrollPane);

        setVisible(true);
    }
    private void addReportsButtons() {
        String[] reportsList = new File(filePath).list();
            if (reportsList.length == 0) {
                emptyLabel = new JLabel("Nie ma zadnych raportow do wyswietlenia");
                emptyLabel.setBounds(110, 10, 300, 20);
                add(emptyLabel);
            } else {
                System.out.println("Jest git");
                comboBox = new JComboBox<>(reportsList);
                comboBox.setBounds(80,10,320,20);
                comboBox.addActionListener(this);
                comboBox.setFocusable(false);
                add(comboBox);
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            reportText.setText(comboBox.getSelectedItem().toString());
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath+"\\"+comboBox.getSelectedItem().toString().toString()));
                String report = inputStream.readObject().toString();
                inputStream.close();
                reportText.setText(report);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
