package InventoryPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import InventoryPackage.CustomSwingComponents.*;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedTextField emailField;
    private RoundedPasswordField passwordField;
    private RoundedPasswordField confirmPasswordField;
    private RoundedTextField firstnameField;
    private RoundedTextField lastnameField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Register frame = new Register();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Register() {
        setTitle("Exodus | Registration");
        setResizable(false);

        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Assets/bg.png"));
        Image backgroundImage = bgIcon.getImage();

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Assets/logo.png"));
        Image logoImage = logoIcon.getImage();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 769, 639);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 753, 600);
        contentPane.add(layeredPane);

        RoundedPanel panel = new RoundedPanel(0, 0);
        panel.setBackgroundImage(backgroundImage);
        panel.setBounds(57, 0, 634, 600);
        layeredPane.add(panel);
        panel.setLayout(null);

        RoundedPanel logoPanel = new RoundedPanel(0, 0);
        logoPanel.setBackgroundImage(logoImage);
        logoPanel.setBounds(231, 67, 147, 149);
        panel.add(logoPanel);

        JLabel titleLabel = new JLabel("Register an Account");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        titleLabel.setBounds(200, 216, 213, 38);
        panel.add(titleLabel);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailLabel.setBounds(154, 260, 45, 32);
        panel.add(emailLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordLabel.setBounds(154, 322, 102, 32);
        panel.add(passwordLabel);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        firstNameLabel.setBounds(154, 448, 102, 32);
        panel.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lastNameLabel.setBounds(333, 448, 102, 32);
        panel.add(lastNameLabel);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmPasswordLabel.setBounds(154, 376, 129, 32);
        panel.add(confirmPasswordLabel);

        emailField = new RoundedTextField(20, 20);
        emailField.setBounds(154, 289, 326, 30);
        panel.add(emailField);

        passwordField = new RoundedPasswordField(20, 20);
        passwordField.setBounds(154, 350, 326, 30);
        panel.add(passwordField);

        confirmPasswordField = new RoundedPasswordField(20, 20);
        confirmPasswordField.setBounds(154, 407, 326, 30);
        panel.add(confirmPasswordField);

        firstnameField = new RoundedTextField(20, 20);
        firstnameField.setBounds(154, 480, 162, 30);
        panel.add(firstnameField);

        lastnameField = new RoundedTextField(20, 20);
        lastnameField.setBounds(324, 480, 156, 30);
        panel.add(lastnameField);

        RoundedButton submitRegisterButton = new RoundedButton("Register", 10, 10);
        submitRegisterButton.setBounds(277, 546, 89, 23);
        panel.add(submitRegisterButton);

        // Add Action Listener for the Register button
        submitRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String firstName = firstnameField.getText();
                String lastName = lastnameField.getText();

                // Validate input
                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                    JOptionPane.showMessageDialog(Register.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(Register.this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Register user
                try {
                    user newUser = new user(email, password, firstName, lastName);
                    if (dbHandler.registerUser(newUser)) {
                        JOptionPane.showMessageDialog(Register.this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // Close the registration window
                    } else {
                        JOptionPane.showMessageDialog(Register.this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Register.this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
