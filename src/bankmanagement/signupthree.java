package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class signupthree extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    String formno , atype;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String accno, pin;

    signupthree(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 140, 200, 30);
        add(l2);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        Random r = new Random();
        long first7 = (r.nextLong() % 90000000L) + 1234432100000000L;
        accno = "" + Math.abs(first7);

        long first3 = (r.nextLong() % 9000L) + 1000L;
        pin = "" + Math.abs(first3);
        l5 = new JLabel("Your 16-digit Account number: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 300, 300, 30);
        add(l5);

        l4 = new JLabel(accno);
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(400, 300, 250, 30);
        add(l4);

        l9 = new JLabel("4-digit password:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 340, 400, 30);
        add(l9);

        l8 = new JLabel(pin);
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(400, 340, 200, 30);
        add(l8);

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 22));
        l10.setBounds(100, 450, 300, 30);
        add(l10);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 20);
        add(c7);

        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250, 720, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(420, 720, 100, 30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 850);
        setLocation(400, 00);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

         atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        String cardno = null;
       

        String facility = "";
        if (c1.isSelected()) {
            Random ran = new Random();
            long first8 = (ran.nextLong() % 90000000L) + 1111222200000000L;
            cardno = "" + Math.abs(first8);
          
            facility = facility + " ATM Card";
        }
        if (c2.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (c3.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (c6.isSelected()) {
            facility = facility + " E-Statement";
        }

        try {
            if (ae.getSource() == b1) {
                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    if (c1.isSelected()) {
                        JOptionPane.showMessageDialog(null, "CARD NO.:" + cardno+"\nPIN NO.:"+pin);
                        

                    }
                    connection c1 = new connection();
                    
                      String q1 = "insert into signupthree values('" + formno + "','" + atype + "','" + accno + "','" + pin + "','" + facility + "','" + cardno + "')";
                    String q2 = "insert into login values('" + formno + "','" + accno + "','" + pin + "')";
                    c1.s.executeUpdate(q1);
                     c1.s.executeUpdate(q2);
                    
                     
                     new deposit(pin).setVisible(true);
                    
                    
                }
            } else if (ae.getSource() == b2) {

        new Login().setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new signupthree("").setVisible(true);
    }
}
