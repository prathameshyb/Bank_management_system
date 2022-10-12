
package bankmanagement;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


class balance extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    balance(String pin) {
        this.pin = pin;

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
         l3 = new JLabel(i3);
        l3.setBounds(0, 00, 900, 900);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(220, 350, 400, 35);
        l3.add(l1);

        b1.setBounds(300, 450, 150, 35);
        l3.add(b1);
        int balance = 0;
        try{
            connection c1 = new connection();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new balance("").setVisible(true);
    }
}
