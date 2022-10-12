package bankmanagement;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signupOne extends JFrame implements ActionListener {

    long rnd;
    JTextField namet, fnamet, mailt, occt, addt, cityt, statet, nationt, pincodet;
    JButton next;
    JRadioButton male, female, other;
    JDateChooser date;
    String formno;

    signupOne() {
        setLayout(null);
        Random r = new Random();
        rnd = Math.abs((r.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION NO: " + rnd);
        formno.setBounds(170, 20, 600, 40);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        add(formno);

        JLabel personDetails = new JLabel("Page:1 Personal Details");
        personDetails.setBounds(250, 80, 400, 30);
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(personDetails);

        JLabel name = new JLabel("NAME: ");
        name.setBounds(120, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 15));
        add(name);

        namet = new JTextField();
        namet.setFont(new Font("Raleway", Font.BOLD, 14));
        namet.setBounds(300, 140, 400, 30);
        add(namet);

        JLabel fname = new JLabel("FATHER'S NAME: ");
        fname.setBounds(120, 190, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 15));
        add(fname);

        fnamet = new JTextField();
        fnamet.setFont(new Font("Raleway", Font.BOLD, 14));
        fnamet.setBounds(300, 190, 400, 30);
        add(fnamet);

        JLabel dob = new JLabel("D.O.B.: ");
        dob.setBounds(120, 240, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 15));
        add(dob);

        date = new JDateChooser();
        date.setBounds(300, 240, 200, 30);
        add(date);

        JLabel gend = new JLabel("GENDER: ");
        gend.setBounds(120, 290, 200, 30);
        gend.setFont(new Font("Raleway", Font.BOLD, 15));
        add(gend);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 70, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 80, 30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(500, 290, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup g = new ButtonGroup();
        g.add(male);
        g.add(female);
        g.add(other);

        JLabel mail = new JLabel("EMAIL: ");
        mail.setBounds(120, 340, 200, 30);
        mail.setFont(new Font("Raleway", Font.BOLD, 15));
        add(mail);

        mailt = new JTextField();
        mailt.setFont(new Font("Raleway", Font.BOLD, 14));
        mailt.setBounds(300, 340, 400, 30);
        add(mailt);

        JLabel occ = new JLabel("OCCUPATION: ");
        occ.setBounds(120, 390, 200, 30);
        occ.setFont(new Font("Raleway", Font.BOLD, 15));
        add(occ);

        occt = new JTextField();
        occt.setFont(new Font("Raleway", Font.BOLD, 14));
        occt.setBounds(300, 390, 400, 30);
        add(occt);

        JLabel add = new JLabel("ADDRESS: ");
        add.setBounds(120, 440, 200, 30);
        add.setFont(new Font("Raleway", Font.BOLD, 15));
        add(add);

        addt = new JTextField();
        addt.setFont(new Font("Raleway", Font.BOLD, 14));
        addt.setBounds(300, 440, 400, 30);
        add(addt);

        JLabel city = new JLabel("CITY: ");
        city.setBounds(120, 490, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 15));
        add(city);

        cityt = new JTextField();
        cityt.setFont(new Font("Raleway", Font.BOLD, 14));
        cityt.setBounds(300, 490, 400, 30);
        add(cityt);

        JLabel state = new JLabel("STATE: ");
        state.setBounds(120, 540, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 15));
        add(state);

        statet = new JTextField();
        statet.setFont(new Font("Raleway", Font.BOLD, 14));
        statet.setBounds(300, 540, 400, 30);
        add(statet);

        JLabel nation = new JLabel("NATIONALITY: ");
        nation.setBounds(120, 590, 200, 30);
        nation.setFont(new Font("Raleway", Font.BOLD, 15));
        add(nation);

        nationt = new JTextField();
        nationt.setFont(new Font("Raleway", Font.BOLD, 14));
        nationt.setBounds(300, 590, 400, 30);
        add(nationt);

        JLabel pincode = new JLabel("PIN CODE: ");
        pincode.setBounds(120, 640, 200, 30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 15));
        add(pincode);

        pincodet = new JTextField();
        pincodet.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodet.setBounds(300, 640, 400, 30);
        add(pincodet);

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
         formno = "" + rnd;
        String name = namet.getText();
        String fname = fnamet.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String g = null;
        if (male.isSelected()) {
            g = "male";
        } else if (female.isSelected()) {
            g = "female";
        } else {
            g = "other";
        }
        String mail = mailt.getText();
        String add = addt.getText();
        String city = cityt.getText();
        String state = statet.getText();
        String nation = nationt.getText();
        String occ = occt.getText();
        String pincode = pincodet.getText();
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required ");
            }

            if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Fathers name is required ");
            }

            if (!male.isSelected() && !female.isSelected() && !other.isSelected()) {
                JOptionPane.showMessageDialog(null, "Gender is required ");
            }

            if (mail.equals("")) {
                JOptionPane.showMessageDialog(null, "Email id is required ");
            }

            if (occ.equals("")) {
                JOptionPane.showMessageDialog(null, "Occupation is required ");
            }

            if (add.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required ");
            }

            if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required ");
            }

            if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required ");
            }

            if (nation.equals("")) {
                JOptionPane.showMessageDialog(null, "Nationality is required ");
            }

            if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN CODE is required ");
            } else {
                connection c = new connection();

                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + g + "','" + mail + "','" + occ + "','" + add + "','" + city + "','" + state + "','" + nation + "','"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        new signupOne();
    }
}
