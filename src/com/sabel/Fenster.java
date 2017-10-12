package com.sabel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends JFrame {

    private JPanel panelWest, panelSouth, panelCenter, panelNorth;
    private JRadioButton radioButtonRed, radioButtonGreen, radioButtonBlue;
    private ButtonGroup radioButtonGroup;
    private JButton buttonRed, buttonGreen, buttonBlue;
    private String[] itemsForComboBox = {"Rot", "Grün", "Blau"};
    private JComboBox<String> comboBox;


    public Fenster() {
        super("Übung Layout");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setSize(600, 600);
        initComponets();
        this.pack();
        this.setVisible(true);

    }

    private void initComponets() {

        //JPanels erzeugen

        panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth = new JPanel();


        //JRadioButtons erzeugen
        radioButtonRed = new JRadioButton("Rot");
        radioButtonRed.setSelected(true);
        radioButtonGreen = new JRadioButton("Grün");
        radioButtonBlue = new JRadioButton("Blau");


        //JRadioButtions Group erzeugen
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonRed);
        radioButtonGroup.add(radioButtonGreen);
        radioButtonGroup.add(radioButtonBlue);


        //JCombox erzeugen
        comboBox = new JComboBox<>(itemsForComboBox);

        //Combobox zu JPanel north hinzufügen
        panelNorth.add(comboBox);

        //JRadioButtons zu Panel hinzufügen
        panelWest.add(radioButtonRed);
        panelWest.add(radioButtonGreen);
        panelWest.add(radioButtonBlue);


        //JButtons erzeugen
        buttonRed = new JButton("Rot");
        buttonGreen = new JButton("Grün");
        buttonBlue = new JButton("Blau");


        //JButton zu Panel South hinzufügen
        panelSouth.add(buttonRed);
        panelSouth.add(buttonGreen);
        panelSouth.add(buttonBlue);


        //Panels zu JFrame hinzufügen
        this.add(panelWest, BorderLayout.WEST);
        this.add(panelCenter);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelNorth, BorderLayout.NORTH);


        //SET BORDER
        panelSouth.setBorder(new TitledBorder(""));
        panelWest.setBorder(new TitledBorder(""));
        panelCenter.setBorder(new TitledBorder(""));


        //Event handling für RadioButtons
        radioButtonRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCenter.setBackground(Color.RED);
            }
        });


        radioButtonGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCenter.setBackground(Color.GREEN);
            }
        });


        radioButtonBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCenter.setBackground(Color.BLUE);
            }
        });


        //Eventhandling für Combobox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) comboBox.getSelectedItem()) {//Methode auf Rückgabewert String gecastet
                    case "Rot":
                        panelCenter.setBackground(Color.RED);
                        comboBox.setSelectedItem("Rot");
                        radioButtonRed.setSelected(true);
                        break;
                    case "Grün":
                        panelCenter.setBackground(Color.GREEN);
                        comboBox.setSelectedItem("Grün");
                        radioButtonGreen.setSelected(true);
                        break;
                    case "Blau":
                        panelCenter.setBackground(Color.BLUE);
                        comboBox.setSelectedItem("Blau");
                        radioButtonBlue.setSelected(true);
                        break;

                }
            }
        });


//Eventhandling für Buttons

        meinInnererActionListener mial = new meinInnererActionListener();
        buttonRed.addActionListener(mial);
        buttonGreen.addActionListener(mial);
        buttonBlue.addActionListener(mial);

    }


    public class meinInnererActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()) {
                case "Rot":
                    panelCenter.setBackground(Color.RED);
                    comboBox.setSelectedItem("Rot");
                    radioButtonRed.setSelected(true);
                    break;
                case "Grün":
                    panelCenter.setBackground(Color.GREEN);
                    comboBox.setSelectedItem("Grün");
                    radioButtonGreen.setSelected(true);
                    break;
                case "Blau":
                    panelCenter.setBackground(Color.BLUE);
                    comboBox.setSelectedItem("Blau");
                    radioButtonBlue.setSelected(true);
                    break;
            }
        }

    }


    public static void main(String[] args) {
        new Fenster();
    }

//Repository-name bei github geänert
}//ende klasse
