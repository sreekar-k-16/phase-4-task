package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class checkprofile extends JFrame implements ActionListener {

    @SuppressWarnings("unused")
    private String email, password;
    private JTextField tfName, tfEmail, tfPassword;
    private JButton edit, save, back;

    public checkprofile(String name, String email, String password) {
        this.email = email;
        this.password = password;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Profile " + name );
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 100, 100, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(nameLabel);

        tfName = new JTextField(name);
        tfName.setBounds(220, 100, 300, 30);
        tfName.setEditable(false);
        add(tfName);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 150, 100, 30);
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(emailLabel);

        tfEmail = new JTextField(email);
        tfEmail.setBounds(220, 150, 300, 30);
        tfEmail.setEditable(false);
        add(tfEmail);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 200, 100, 30);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(passwordLabel);

        tfPassword = new JPasswordField(password);
        tfPassword.setBounds(220, 200, 300, 30);
        tfPassword.setEditable(false);
        add(tfPassword);

        edit = new JButton("Edit");
        edit.setBounds(150, 270, 100, 30);
        edit.setBackground(new Color(30, 144, 254));
        edit.setForeground(Color.WHITE);
        edit.addActionListener(this);
        add(edit);

        save = new JButton("Save");
        save.setBounds(280, 270, 100, 30);
        save.setBackground(new Color(30, 144, 254));
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        save.setVisible(false); // Initially hidden
        add(save);

        back = new JButton("Back");
        back.setBounds(410, 270, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(600, 400);
        setLocationRelativeTo(null); // Center the JFrame on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == edit) {
            tfName.setEditable(true);
            tfEmail.setEditable(true);
            tfPassword.setEditable(true);
            edit.setVisible(false);
            save.setVisible(true);
        } else if (ae.getSource() == save) {
            tfName.getText();
            email = tfEmail.getText();
            password = tfPassword.getText();
            
            // Update UI
            tfName.setEditable(false);
            tfEmail.setEditable(false);
            tfPassword.setEditable(false);
            edit.setVisible(true);
            save.setVisible(false);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new checkprofile("User", "user@example.com", "Password");
    }
}
