package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    transactions(String pin) {
this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 00, 900, 900);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(250, 320, 700, 35);
        l2.add(l1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(220, 360, 150, 35);
        b1.addActionListener(this);
        l2.add(b1);
        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(390, 360, 150, 35);
        b2.addActionListener(this);
        l2.add(b2);
        b3 = new JButton("FAST CASH");
        b3.setBounds(220, 400, 150, 35);
        b3.addActionListener(this);
        l2.add(b3);
        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(390, 400, 150, 35);
        b4.addActionListener(this);
        l2.add(b4);
        b5 = new JButton("PIN CHANGE");
        b5.setBounds(220, 440, 150, 35);
        b5.addActionListener(this);
        l2.add(b5);
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(390, 440, 150, 35);
        b6.addActionListener(this);
        l2.add(b6);
        b7 = new JButton("EXIT");
        b7.setBounds(300, 480, 150, 35);
        b7.addActionListener(this);
        l2.add(b7);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b7) {
            System.exit(0);
        }else  if (ae.getSource() == b1) {
            setVisible(false);
          new deposit(pin).setVisible(true);
        }else  if (ae.getSource() == b2) {
              setVisible(false);
          new withdraw(pin).setVisible(true);
        }
        else  if (ae.getSource() == b3) {
              setVisible(false);
          new fastcash(pin).setVisible(true);
        }
         else  if (ae.getSource() == b4) {
            
          new ministatement(pin).setVisible(true);
        }
        else  if (ae.getSource() == b6) {
              setVisible(false);
         new balance(pin).setVisible(true);
        }
        else  if (ae.getSource() == b5) {
              setVisible(false);
          new pinchange(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {

        new transactions("").setVisible(true);
    }
}
