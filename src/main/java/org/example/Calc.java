package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Calc extends JFrame implements ActionListener {
    private JButton addition;
    private JButton substraction;
    private JButton derivative;
    private JButton integrated;
    private JButton multiply;
    private JButton division;
    private JTextField text1;
    private JTextField text2;
    private JLabel text3;
    private Polynomial polinom1 = new Polynomial();
    private Polynomial polinom2 = new Polynomial();

    public Calc() {

        this.setTitle("Calculator polinomial");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(300, 300, 500, 500);
        this.setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 500);

        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JLabel();

        JLabel label1 = new JLabel("polinom1");
        JLabel label2 = new JLabel("polinom2");
        JLabel label3 = new JLabel("rezultat");

        text1.setBounds(0, 100, 250, 40);
        text2.setBounds(0, 140, 250, 40);
        text3.setBounds(0, 180, 250, 40);

        label1.setBounds(260, 100, 100, 40);
        label2.setBounds(260, 140, 100, 40);
        label3.setBounds(260, 180, 100, 40);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        panel.add(text1);
        panel.add(text2);
        panel.add(text3);

        addition = new JButton("addition");
        substraction = new JButton("substraction");
        derivative = new JButton("derivative");
        integrated = new JButton("integrated");
        multiply = new JButton("multiply");
        division = new JButton("division");

        addition.setBounds(0, 250, 200, 25);
        substraction.setBounds(0, 275, 200, 25);
        derivative.setBounds(0, 300, 200, 25);
        integrated.setBounds(0, 325, 200, 25);
        multiply.setBounds(0, 350, 200, 25);
        division.setBounds(0, 375, 200, 25);

        addition.addActionListener(this);
        substraction.addActionListener(this);
        derivative.addActionListener(this);
        integrated.addActionListener(this);
        multiply.addActionListener(this);
        division.addActionListener(this);

        panel.add(addition);
        panel.add(substraction);
        panel.add(derivative);
        panel.add(integrated);
        panel.add(multiply);
        panel.add(division);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addition) {
            text3.setText("");
            String pol1 = text1.getText();
            String pol2 = text2.getText();
            String valid1=polinom1.findElements(pol1);
            String valid2=polinom2.findElements(pol2);
            if(valid1.isEmpty() && valid2.isEmpty()) {
                String pol3 = Operations.addPolynomials(polinom1.getPolinom(), polinom2.getPolinom());
                text3.setText(pol3);
            }
            else if(!valid1.isEmpty()){
                text3.setText(valid1);
            }
            else text3.setText(valid2);
            polinom2.getPolinom().clear();
            polinom1.getPolinom().clear();

        } else if (e.getSource() == substraction) {
            text3.setText("");
            String pol1 = text1.getText();
            String pol2 = text2.getText();
            String valid1=polinom1.findElements(pol1);
            String valid2=polinom2.findElements(pol2);
            if(valid1.isEmpty() && valid2.isEmpty()) {
                String pol3 = Operations.subPolynomials(polinom1.getPolinom(), polinom2.getPolinom());
                text3.setText(pol3);
            }
            else if(!valid1.isEmpty()){
                text3.setText(valid1);
            }
            else text3.setText(valid2);
            polinom2.getPolinom().clear();
            polinom1.getPolinom().clear();

        } else if (e.getSource() == division) {
            text3.setText("");
            String pol1 = text1.getText();
            String pol2 = text2.getText();
            String valid1=polinom1.findElements(pol1);
            String valid2=polinom2.findElements(pol2);
            if(valid1.isEmpty() && valid2.isEmpty()) {
                String pol3;
                if(polinom1.getPolinom().firstKey()>polinom2.getPolinom().firstKey())
                    pol3 = Operations.divPolynomials(polinom1.getPolinom(), polinom2.getPolinom());
                else pol3=Operations.divPolynomials(polinom2.getPolinom(), polinom1.getPolinom());
                text3.setText(pol3);
            }
            else if(!valid1.isEmpty()){
                text3.setText(valid1);
            }
            else text3.setText(valid2);
            polinom2.getPolinom().clear();
            polinom1.getPolinom().clear();

        } else if (e.getSource() == derivative) {
            text3.setText("");
            String pol1 = text1.getText();

            String valid1=polinom1.findElements(pol1);

            if(valid1.isEmpty()) {
                String pol3 = Operations.derPolynomials(polinom1.getPolinom());
                text3.setText(pol3);
            }
            else if(!valid1.isEmpty()){
                text3.setText(valid1);
            }

            polinom1.getPolinom().clear();

        } else if (e.getSource() == multiply) {
            text3.setText("");
            String pol1 = text1.getText();
            String pol2 = text2.getText();
            String valid1=polinom1.findElements(pol1);
            String valid2=polinom2.findElements(pol2);
            if(valid1.isEmpty() && valid2.isEmpty()) {
                String pol3 = Operations.mulPolynomials(polinom1.getPolinom(), polinom2.getPolinom());
                text3.setText(pol3);
            }
            else if(!valid1.isEmpty()){
                text3.setText(valid1);
            }
            else text3.setText(valid2);
            polinom2.getPolinom().clear();
            polinom1.getPolinom().clear();

        } else if (e.getSource() == integrated) {
            text3.setText("");
            String pol1 = text1.getText();

            String valid1=polinom1.findElements(pol1);

            if(valid1.isEmpty()) {
                String pol3 = Operations.intPolynomials(polinom1.getPolinom());
                text3.setText(pol3);
            }
            else if(!valid1.isEmpty()){
                text3.setText(valid1);
            }

            polinom1.getPolinom().clear();

        }
    }
}



