package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton checkProfile, next;
    JTextField tfname, tfemail;
    JPasswordField tfpassword;

    // Define the list of valid passwords
    private final String[] validPasswords = {"12345", "Quiz", "54321"};

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        JLabel email = new JLabel("Enter your gmail address");
        email.setBounds(810, 250, 300, 20);
        email.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        email.setForeground(new Color(30, 144, 254));
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(735, 300, 300, 25);
        tfemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfemail);

        JLabel password = new JLabel("Enter your password");
        password.setBounds(810, 350, 300, 20);
        password.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        password.setForeground(new Color(30, 144, 254));
        add(password);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(735, 400, 300, 25);
        tfpassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfpassword);

        checkProfile = new JButton("Check Profile");
        checkProfile.setBounds(735, 470, 150, 25);
        checkProfile.setBackground(new Color(30, 144, 254));
        checkProfile.setForeground(Color.WHITE);
        checkProfile.addActionListener(this);
        add(checkProfile);

        next = new JButton("Next");
        next.setBounds(915, 470, 120, 25);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(1200, 700);
        setLocation(200, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkProfile) {
            String name = tfname.getText();
            String email = tfemail.getText();
            String password = new String(tfpassword.getPassword());
            setVisible(false);
            new checkprofile(name, email, password); // Corrected class name
        } else if (ae.getSource() == next) {
            String name = tfname.getText();
            String password = new String(tfpassword.getPassword());
            if (isValidPassword(password)) {
                setVisible(false);
                new Quiz(name); // Start the quiz with the entered name
            } else {
                JOptionPane.showMessageDialog(this, "Invalid password. Please try again.");
            }
        }
    }

    // Method to check if the entered password is valid
    private boolean isValidPassword(String password) {
        for (String validPassword : validPasswords) {
            if (validPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Login();
    }
}
