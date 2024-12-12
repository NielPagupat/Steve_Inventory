package InventoryPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import InventoryPackage.CustomSwingComponents.*;

import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class dashboardPOS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundedTextField barcodeField;
	private RoundedTextField productField;
	private RoundedTextField priceField;
	private RoundedTextField quantityField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboardPOS frame = new dashboardPOS();
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
	public dashboardPOS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 959, 661);
		contentPane.add(layeredPane);
		
		JPanel BackgroundPnl = new RoundedPanel(50,50);
		BackgroundPnl.setOpaque(false);
		BackgroundPnl.setBackground(Color.GRAY);
		BackgroundPnl.setBounds(0, 25, 959, 614);
		layeredPane.add(BackgroundPnl);
		
		JPanel panel = new JPanel();
		layeredPane.setLayer(panel, 1);
		panel.setBounds(0, 290, 218, 371);
		layeredPane.add(panel);
		
		JPanel contentPnl = new JPanel();
		contentPnl.setOpaque(false);
		layeredPane.setLayer(contentPnl, 2);
		contentPnl.setBounds(0, 0, 959, 661);
		layeredPane.add(contentPnl);
		contentPnl.setLayout(null);
		
		JLabel Title = new JLabel("EXODUS");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Times New Roman", Font.PLAIN, 70));
		Title.setBounds(149, 48, 316, 69);
		contentPnl.add(Title);
		
		JLabel SubText = new JLabel("Dress the future");
		SubText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SubText.setBounds(330, 111, 121, 14);
		contentPnl.add(SubText);
		
		JPanel receiptPnl = new RoundedPanel(30,30);
		receiptPnl.setOpaque(false);
		receiptPnl.setBackground(Color.LIGHT_GRAY);
		receiptPnl.setBounds(87, 146, 378, 390);
		contentPnl.add(receiptPnl);
		receiptPnl.setLayout(null);
		
		JLabel receiptLbl = new JLabel("RECEIPT");
		receiptLbl.setBounds(156, 5, 65, 19);
		receiptLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		receiptPnl.add(receiptLbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 30, 378, 360);
		receiptPnl.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel totalPnl = new RoundedPanel(30,30);
		totalPnl.setOpaque(false);
		totalPnl.setBackground(Color.LIGHT_GRAY);
		totalPnl.setBounds(87, 547, 378, 53);
		contentPnl.add(totalPnl);
		totalPnl.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOTAL AMOUNT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 160, 31);
		totalPnl.add(lblNewLabel);
		
		JPanel AmountPanel = new RoundedPanel(30,30);
		AmountPanel.setOpaque(false);
		AmountPanel.setBounds(180, 11, 188, 31);
		totalPnl.add(AmountPanel);
		
		JPanel addedPnl = new RoundedPanel(30,30);
		addedPnl.setBounds(496, 48, 431, 235);
		contentPnl.add(addedPnl);
		
		JLabel barcodeLbl = new JLabel("BARCODE");
		barcodeLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		barcodeLbl.setBounds(508, 358, 121, 28);
		contentPnl.add(barcodeLbl);
		
		JLabel productLbl = new JLabel("PRODUCT");
		productLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productLbl.setBounds(508, 428, 121, 28);
		contentPnl.add(productLbl);
		
		JLabel priceLbl = new JLabel("PRICE");
		priceLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLbl.setBounds(508, 497, 121, 28);
		contentPnl.add(priceLbl);
		
		JLabel quantityLbl = new JLabel("QUANTITY");
		quantityLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLbl.setBounds(508, 563, 121, 28);
		contentPnl.add(quantityLbl);
		
		barcodeField = new RoundedTextField(20,20);
		barcodeField.setBounds(496, 333, 300, 30);
		contentPnl.add(barcodeField);
		barcodeField.setColumns(10);
		
		productField = new RoundedTextField(20,20);
		productField.setColumns(10);
		productField.setBounds(496, 397, 300, 30);
		contentPnl.add(productField);
		
		priceField = new RoundedTextField(20,20);
		priceField.setColumns(10);
		priceField.setBounds(496, 467, 300, 30);
		contentPnl.add(priceField);
		
		quantityField = new RoundedTextField(20,20);
		quantityField.setColumns(10);
		quantityField.setBounds(496, 536, 300, 30);
		contentPnl.add(quantityField);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.setBounds(824, 514, 89, 51);
		contentPnl.add(btnNewButton);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(824, 446, 89, 51);
		contentPnl.add(btnAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFind.setBounds(806, 333, 73, 28);
		contentPnl.add(btnFind);
	}
}
