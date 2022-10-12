package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class fastcash extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    fastcash(String pin) {
this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 00, 900, 900);
        add(l2);

        l1 = new JLabel("Select withdrawl amount: ");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(250, 320, 700, 35);
        l2.add(l1);

        b1 = new JButton("Rs.100");
        b1.setBounds(220, 360, 150, 35);
        b1.addActionListener(this);
        l2.add(b1);
        b2 = new JButton("Rs.500");
        b2.setBounds(390, 360, 150, 35);
        b2.addActionListener(this);
        l2.add(b2);
        b3 = new JButton("Rs.1000");
        b3.setBounds(220, 400, 150, 35);
        b3.addActionListener(this);
        l2.add(b3);
        b4 = new JButton("Rs.2000");
        b4.setBounds(390, 400, 150, 35);
        b4.addActionListener(this);
        l2.add(b4);
        b5 = new JButton("Rs.5000");
        b5.setBounds(220, 440, 150, 35);
        b5.addActionListener(this);
        l2.add(b5);
        b6 = new JButton("Rs.10000");
        b6.setBounds(390, 440, 150, 35);
        b6.addActionListener(this);
        l2.add(b6);
        b7 = new JButton("Back");
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
        setVisible(false);
        new transactions(pin).setVisible(true);
        }else  {
        String amount=((JButton)ae.getSource()).getText().substring(3);
        connection c=new connection();
        try{
            
            ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pin+"'");
            int balance=0;
            while(rs.next())  {
            if(rs.getString("type").equals("Deposit"))
               balance+=Integer.parseInt(rs.getString("amount"));
           else  if(rs.getString("type").equals("withdraw"))
               balance -=Integer.parseInt(rs.getString("amount"));
            } 
            if(ae.getSource()!=b7&&balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient balance");
                return;}
                Date date=new Date();
                  c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'withdraw', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new transactions(pin).setVisible(true);
                
        }catch(Exception e){
        System.out.println(e);}
                }
    }

    public static void main(String[] args) {

        new fastcash("").setVisible(true);
    }
}

