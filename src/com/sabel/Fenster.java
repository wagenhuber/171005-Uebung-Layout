package com.sabel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends JFrame {

    private JPanel panelWest, panelSouth, panelCenter;
    private JRadioButton radioButtonRed, radioButtonGreen, radioButtonBlue;
    private ButtonGroup radioButtonGroup;
    private JButton buttonRed, buttonGreen, buttonBlue;


    public Fenster() {
        super("Übung Layout");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        initComponets();
        this.setVisible(true);

    }

    private void initComponets() {
        panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));


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


        //JRadioButtons zu Panel hinzufügen
        panelWest.add(radioButtonRed);
        panelWest.add(radioButtonGreen);
        panelWest.add(radioButtonBlue);



        //JPanels erzeugen
        panelCenter = new JPanel();
        panelSouth = new JPanel();


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


        //SET BORDER
        panelSouth.setBorder(new TitledBorder(""));
        panelWest.setBorder(new TitledBorder(""));
        panelCenter.setBorder(new TitledBorder(""));


        //Event handling
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

    }

    public static void main(String[] args) {
        new Fenster();
    }

//Repository-name bei github geänert
}//ende klasse
