package InventoryPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


import InventoryPackage.CustomSwingComponents.*;


public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundedTextField emailField;
	private RoundedPasswordField passwordField;
	private RoundedPasswordField ConfirmPasswordField;
	private RoundedTextField firstnameField;
	private RoundedTextField lastnameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 639);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 753, 600);
		contentPane.add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(160, 0, 454, 600);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JPanel RegistrationPanel = new JPanel();
		RegistrationPanel.setBounds(151, 67, 147, 149);
		panel.add(RegistrationPanel);
		
		JLabel lblNewLabel = new JLabel("Register an Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(120, 216, 213, 38);
		panel.add(lblNewLabel);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailLbl.setBounds(74, 260, 45, 32);
		panel.add(emailLbl);
		
		JLabel PasswordLbl = new JLabel("Password");
		PasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PasswordLbl.setBounds(74, 322, 102, 32);
		panel.add(PasswordLbl);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(74, 448, 102, 32);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(253, 448, 102, 32);
		panel.add(lblLastName);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(74, 376, 129, 32);
		panel.add(lblConfirmPassword);
		
		emailField = new RoundedTextField(20,20);
		emailField.setBounds(74, 289, 326, 30);
		panel.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new RoundedPasswordField(20,20);
		passwordField.setColumns(10);
		passwordField.setBounds(74, 350, 326, 30);
		panel.add(passwordField);
		
		ConfirmPasswordField = new RoundedPasswordField(20,20);
		ConfirmPasswordField.setColumns(10);
		ConfirmPasswordField.setBounds(74, 407, 326, 30);
		panel.add(ConfirmPasswordField);
		
		firstnameField = new RoundedTextField(20,20);
		firstnameField.setColumns(10);
		firstnameField.setBounds(74, 480, 162, 30);
		panel.add(firstnameField);
		
		lastnameField = new RoundedTextField(20,20);
		lastnameField.setColumns(10);
		lastnameField.setBounds(244, 480, 156, 30);
		panel.add(lastnameField);
		
		RoundedButton SubmitRegisterBtn = new RoundedButton("Register", 10, 10);
		SubmitRegisterBtn.setBounds(197, 546, 89, 23);
		panel.add(SubmitRegisterBtn);
		
		
	}
}
