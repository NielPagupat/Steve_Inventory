package InventoryPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import InventoryPackage.CustomSwingComponents.*;

public class Login {

	private JFrame frmExodus;
	private RoundedTextField EmailField;
	private RoundedPasswordField passwordField;
	private static String loginResult = ""; 
	private static String Email;
	
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
		
		ImageIcon BG = new ImageIcon(getClass().getResource("/Assets/bg.png"));
        Image backgroundImage = BG.getImage();
        
        
        ImageIcon lg = new ImageIcon(getClass().getResource("/Assets/logo.png"));
        Image logo = lg.getImage();
        
        ImageIcon as1 = new ImageIcon(getClass().getResource("/Assets/Asset1.png"));
        Image Asset1 = as1.getImage();
        
		frmExodus = new JFrame();
		frmExodus.setResizable(false);
		frmExodus.setTitle("Exodus | Log-In");
		frmExodus.getContentPane().setBackground(new Color(228, 228, 228));
		frmExodus.setBounds(100, 100, 770, 639);
		frmExodus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExodus.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(0, 0, 760, 608);
		frmExodus.getContentPane().add(layeredPane);
		
		RoundedPanel LoginPanel = new RoundedPanel(100,100);
		LoginPanel.setOpaque(false);
		LoginPanel.setBackgroundImage(backgroundImage);
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
		
		RoundedPanel Logo = new RoundedPanel(0,0);
		Logo.setBackgroundImage(logo);
		
		Logo.setBounds(439, 45, 300, 200);
		LoginPanel.add(Logo);
		LoginPanel.setBackgroundImage(backgroundImage);
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
				
				String email = EmailField.getText();
                String password = new String(passwordField.getPassword());
                try {
                    if (dbHandler.loginUser(email, password)) {
                        loginResult = "Valid";
                        Email = email;
                        frmExodus.dispose(); // Close the login window
                    } else {
                    	JOptionPane.showMessageDialog(frmExodus, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    loginResult = "Error";
                }
				
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
				
				loginResult = "Register";
			}
		});
		RegisterBtn.setBounds(608, 445, 108, 23);
		LoginPanel.add(RegisterBtn);
		
		RoundedPanel AssetPanel = new RoundedPanel(0,0);
		AssetPanel.setOpaque(false);
		AssetPanel.setBorder(null);
		AssetPanel.setBounds(-92, 149, 597, 419);
		AssetPanel.setBackgroundImage(Asset1);
		LoginPanel.add(AssetPanel);
		
		layeredPane.setLayer(AssetPanel, 1);
	}
	
	public static String getLoginResult() {
        return loginResult;
    }
	public static String getEmail() {
        return Email;
    }
}
