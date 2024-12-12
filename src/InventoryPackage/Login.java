package InventoryPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import InventoryPackage.CustomSwingComponents.*;


public class Login {

	private JFrame frmExodus;
	private RoundedTextField EmailField;
	private RoundedPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmExodus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExodus = new JFrame();
		frmExodus.setResizable(false);
		frmExodus.setTitle("Exodus");
		frmExodus.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmExodus.setBounds(100, 100, 769, 639);
		frmExodus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExodus.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(0, 0, 760, 608);
		frmExodus.getContentPane().add(layeredPane);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(128, 128, 128));
		LoginPanel.setBounds(0, 39, 760, 526);
		layeredPane.add(LoginPanel);
		LoginPanel.setLayout(null);
		
		JLabel Title = new JLabel("EXODUS");
		Title.setFont(new Font("Times New Roman", Font.PLAIN, 70));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(45, 70, 316, 83);
		LoginPanel.add(Title);
		layeredPane.setLayer(Title, 1);
		
		JLabel SubText = new JLabel("Dress the future");
		SubText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SubText.setBounds(231, 144, 151, 14);
		LoginPanel.add(SubText);
		
		JPanel Logo = new JPanel();
		Logo.setBounds(499, 70, 175, 175);
		LoginPanel.add(Logo);
		
		EmailField = new RoundedTextField(20,20);
		EmailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EmailField.setToolTipText("Email");
		EmailField.setBounds(439, 299, 300, 30);
		LoginPanel.add(EmailField);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EmailLabel.setBounds(449, 274, 68, 23);
		LoginPanel.add(EmailLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PasswordLabel.setToolTipText("password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordLabel.setBounds(449, 340, 86, 23);
		LoginPanel.add(PasswordLabel);
		
		passwordField = new RoundedPasswordField(20,20);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(439, 363, 300, 30);
		LoginPanel.add(passwordField);
		
		JButton LoginButton = new RoundedButton("Log-In", 10, 10);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LoginButton.setBounds(533, 404, 120, 30);
		LoginPanel.add(LoginButton);
		
		JLabel lblNewLabel = new JLabel("EXODUS | Cashier");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(523, 501, 120, 14);
		LoginPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Don't Have an account?");
		lblNewLabel_1.setBounds(486, 449, 140, 14);
		LoginPanel.add(lblNewLabel_1);
		
		JButton RegisterBtn = new JButton("Click Here");
		RegisterBtn.setHorizontalAlignment(SwingConstants.LEADING);
		RegisterBtn.setForeground(Color.BLUE);
		RegisterBtn.setContentAreaFilled(false);
	    RegisterBtn.setBorderPainted(false);
	    RegisterBtn.setFocusPainted(false);
	    RegisterBtn.setOpaque(false);
		RegisterBtn.setBackground(new Color(255, 255, 255));
		RegisterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RegisterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RegisterBtn.setBounds(608, 445, 108, 23);
		LoginPanel.add(RegisterBtn);
		
		JPanel AssetPanel = new JPanel();
		AssetPanel.setBounds(61, 208, 276, 400);
		layeredPane.add(AssetPanel);
		AssetPanel.setBackground(Color.DARK_GRAY);
		layeredPane.setLayer(AssetPanel, 1);
	}
}
