package org.example.SwingView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class BattleReportFrame extends JPanel{

    private final String filePath = "C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\BattleReports";
    private JTextArea reportText;
    private JLabel emptyLabel;
    private JComboBox<String> comboBox;
    private JScrollPane scrollPane;

    public BattleReportFrame(){
        setBounds(0,0,500,500);
        setLayout(null);

        reportText = new JTextArea("Wybierz raport do wsywietlenia");
        reportText.setFocusable(false);
        reportText.setLineWrap(true);
        reportText.setFont(new Font("Arial",Font.PLAIN,12));
        reportText.setEditable(false);
        reportText.setBounds(0,0,400,1000);
        reportText.setPreferredSize(new Dimension(400,1000));

        scrollPane = new JScrollPane(reportText);
        scrollPane.setBounds(40,40,400,400);
        scrollPane.setPreferredSize(new Dimension(400,400));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        addReportsButtons();
        add(scrollPane);
        repaint();

        setVisible(true);
    }
    private void addReportsButtons() {
        String[] reportsList = new File(filePath).list();
            if (reportsList.length == 0) {
                emptyLabel = new JLabel("Nie ma zadnych raportow do wyswietlenia");
                emptyLabel.setBounds(110, 10, 300, 20);
                add(emptyLabel);
            } else {
                comboBox = new JComboBox<String>(reportsList);
                comboBox.setBounds(80,10,320,20);
                comboBox.addActionListener(e -> {
                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath+"\\"+comboBox.getSelectedItem().toString()));
                        String report = inputStream.readObject().toString();
                        inputStream.close();
                        System.out.println(report);
                        reportText.setText(report);
                    } catch (Exception ex) {
                        System.out.println("asd cos nie tak");
                        throw new RuntimeException(ex);
                    }
                });
                comboBox.setFocusable(false);
                add(comboBox);
            }
    }
}
