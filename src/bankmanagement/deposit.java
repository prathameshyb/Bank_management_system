package bankmanagement;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import java.awt.event.*;

public class deposit extends JFrame implements ActionListener  {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    deposit(String pin) {
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 00, 900, 900);
        add(l2);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(215, 310, 400, 35);
        l2.add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(320, 370, 130, 25);
        l2.add(t1);

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
         b1.setBounds(215,450,150,35);
        l2.add(b1);
        
        b2.setBounds(380,450,150,35);
        l2.add(b2);
            b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
      public void actionPerformed(ActionEvent ae){
      
           try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    connection c1 = new connection();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
      
      
      }

    public static void main(String[] args) {

        new deposit("").setVisible(true);
    }
}
