package bankmanagement;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class signuptwo extends JFrame implements ActionListener {

    
    JTextField namet, incomet, edut, aadhart, existingt, cityt,pant;
    JButton next;
    JComboBox religionc;
    JRadioButton yes,no,yesm,nom;
    String formno;

    signuptwo(String formno) {
        this.formno=formno;
        setLayout(null);
      setTitle("New application : PAGE 2");

        JLabel additionaldetails = new JLabel("Form No. "+this.formno+" PAGE:2 ");
        additionaldetails.setBounds(170, 20, 600, 40);
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 38));
        add(additionaldetails);

        JLabel personDetails = new JLabel("Personal Details");
        personDetails.setBounds(250, 80, 400, 30);
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(personDetails);

        JLabel religion = new JLabel("RELIGION: ");
        religion.setBounds(120, 140, 100, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 15));
        add(religion);
        
        String valReligion[]={"NULL","Hindu","Islamic","Christian","Sikh","Jain","Other"};
         religionc=new JComboBox(valReligion);
        religionc.setBackground(Color.white);
        religionc.setBounds(300, 140, 400, 30);
        add(religionc);
       

        JLabel income = new JLabel("INCOME: ");
        income.setBounds(120, 190, 200, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 15));
        add(income);

        incomet = new JTextField();
        incomet.setFont(new Font("Raleway", Font.BOLD, 14));
        incomet.setBounds(300, 190, 400, 30);
        add(incomet);

        JLabel edu = new JLabel("EDUCATIONAL: ");
        edu.setBounds(120, 240, 200, 30);
        edu.setFont(new Font("Raleway", Font.BOLD, 15));
        add(edu);
        
       
         edut = new JTextField();
        edut.setFont(new Font("Raleway", Font.BOLD, 14));
        edut.setBounds(300, 240, 400, 30);
        add(edut);
        


        JLabel senior = new JLabel("SENIOR CITIZEN: ");
        senior.setBounds(120, 290, 200, 30);
        senior.setFont(new Font("Raleway", Font.BOLD, 15));
        add(senior);

        yes = new JRadioButton("YES");
        yes.setBounds(300, 290, 70, 30);
        yes.setBackground(Color.white);
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(400, 290, 80, 30);
        no.setBackground(Color.white);
        add(no);

       

        ButtonGroup sc = new ButtonGroup();
        sc.add(yes);
        sc.add(no);
// 

        JLabel pan = new JLabel("PAN NO.: ");
        pan.setBounds(120, 340, 200, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 15));
        add(pan);

        pant = new JTextField();
        pant.setFont(new Font("Raleway", Font.BOLD, 14));
        pant.setBounds(300, 340, 400, 30);
        add(pant);

        JLabel aadhar = new JLabel("AADHAR NO.: ");
        aadhar.setBounds(120, 390, 200, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 15));
        add(aadhar);

        aadhart = new JTextField();
        aadhart.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhart.setBounds(300, 390, 400, 30);
        add(aadhart);

        JLabel existing = new JLabel("EXISTING ACCOUNT: ");
        existing.setBounds(120, 440, 200, 30);
        existing.setFont(new Font("Raleway", Font.BOLD, 15));
        add(existing);
        
        JLabel na=new JLabel("(Put NA for new account) ");
          na.setBounds(120, 465, 200, 15);
        na.setFont(new Font("Raleway", Font.BOLD, 10));
        add(na);
        
        

        existingt = new JTextField();
        existingt.setFont(new Font("Raleway", Font.BOLD, 14));
        existingt.setBounds(300, 440, 400, 30);
        add(existingt);

        JLabel minor = new JLabel("MINOR: ");
        minor.setBounds(120, 490, 200, 30);
        minor.setFont(new Font("Raleway", Font.BOLD, 15));
        add(minor);
        
         yesm = new JRadioButton("YES");
        yesm.setBounds(300, 490, 70, 30);
        yesm.setBackground(Color.white);
        add(yesm);

        nom = new JRadioButton("NO");
        nom.setBounds(400, 490, 80, 30);
        nom.setBackground(Color.white);
        add(nom);

      
        ButtonGroup mn = new ButtonGroup();
        mn.add(yesm);
        mn.add(nom);
 
    
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 680, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
     
        String religion=(String)religionc.getSelectedItem();
        String income = incomet.getText();
        String edu = edut.getText();
        
        String senior = null;
        if (yes.isSelected()) {
            senior = "yes";
        } else   {
            senior = "no";
        }
        
         String minor = null;
        if (yesm.isSelected()) {
            minor = "yes";
        } else   {
            minor = "no";
        }
        String pan = pant.getText();
        String aadhar = aadhart.getText();
        String existing = existingt.getText();
        
    
        
        try {
            if (income.equals("")) {
                JOptionPane.showMessageDialog(null, "Income is required ");
            }

            if (edu.equals("")) {
                JOptionPane.showMessageDialog(null, "Educational details are required ");
            }

            if (!yes.isSelected() && !no.isSelected() ) {
                JOptionPane.showMessageDialog(null, "Senior citizen cannot be empty ");
            }

            if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN No. is required ");
            }

            if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is required ");
            }

      
//
            if (existing.equals("")) {
                JOptionPane.showMessageDialog(null, "Existing account details are required!");
            }

        else {
                connection c = new connection();
//
               String query = "insert into signuptwo values('" + formno + "','" + income + "','" + edu + "','" + senior + "','" + pan + "','" + aadhar + "','" + existing + "','" + minor + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupthree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
       }

    }

  public static void main(String[] args) {

        new signuptwo("");
    }}

  


