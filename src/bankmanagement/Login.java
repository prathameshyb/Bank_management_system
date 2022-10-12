package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1,accTextField;
    
    JPasswordField pinTextField;
    JButton login, clear, signup;

    Login() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        l1 = new JLabel("WELCOME TO MyATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 450, 40);
        add(l1);

        l2 = new JLabel("Account No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        accTextField = new JTextField(15);
        accTextField.setBounds(300, 150, 230, 30);
        accTextField.setFont(new Font("Arial", Font.BOLD, 14));
        accTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(accTextField);

        l3 = new JLabel("Password: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 200, 375, 30);
        add(l3);

        pinTextField = new JPasswordField(15);
        pinTextField.setBounds(300, 200, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(370, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("MyATM");
        setSize(900, 480);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==login){
                String accnumber=accTextField.getText();
                String pin=pinTextField.getText();
            connection conn=new connection();
            String query="select * from login where accno='"+accnumber+"' and pin='"+pin+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                 if(rs.next()){
                 setVisible(false);
                 new transactions(pin).setVisible(true);}
                 else{
                 JOptionPane.showMessageDialog(null, "Incorrect account no. or password");}
            }catch(Exception e){
            System.out.println(e);}
            }
            else if(ae.getSource()==clear){
                accTextField.setText("");
                pinTextField.setText((""));
                        
            }
            else if(ae.getSource()==signup){
           setVisible(false);
           new signupOne().setVisible(true);
            }
    }

    public static void main(String[] args) {

        new Login().setVisible(true);
    }

}
