package InventoryPackage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import InventoryPackage.CustomSwingComponents.*;

public class dashboardPOS extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedTextField barcodeField;
    private RoundedTextField productField;
    private RoundedTextField priceField;
    private RoundedTextField quantityField;
    private RoundedPanel addedPnl;
    private JPanel receiptContentPanel;
    private RoundedPanel AmountPanel;
    private List<products> productList = new ArrayList<>();

    private static String email;

    public static void main(String[] args, String Email) {
        email = Email;
        EventQueue.invokeLater(() -> {
            try {
                dashboardPOS frame = new dashboardPOS();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public dashboardPOS() {
        setTitle("Exodus | Dashboard");

        ImageIcon BG = new ImageIcon(getClass().getResource("/Assets/bg.png"));
        Image backgroundImage = BG.getImage();

        ImageIcon as1 = new ImageIcon(getClass().getResource("/Assets/Asset1.png"));
        Image Asset1 = as1.getImage();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 975, 700);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 959, 661);
        contentPane.add(layeredPane);

        RoundedPanel BackgroundPnl = new RoundedPanel(50, 50);
        BackgroundPnl.setOpaque(false);
        BackgroundPnl.setBackgroundImage(backgroundImage);
        BackgroundPnl.setBounds(0, 25, 959, 614);
        layeredPane.add(BackgroundPnl);

        RoundedPanel panel = new RoundedPanel(0, 0);
        panel.setBackgroundImage(Asset1);
        layeredPane.setLayer(panel, 1);
        panel.setBounds(-200, 199, 586, 462);
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

        JPanel receiptPnl = new RoundedPanel(30, 30);
        receiptPnl.setOpaque(false);
        receiptPnl.setBackground(Color.LIGHT_GRAY);
        receiptPnl.setBounds(87, 146, 378, 390);
        contentPnl.add(receiptPnl);
        receiptPnl.setLayout(null);

        JLabel receiptLbl = new JLabel("RECEIPT");
        receiptLbl.setBounds(156, 5, 65, 19);
        receiptLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        receiptPnl.add(receiptLbl);

        receiptContentPanel = new JPanel();
        receiptContentPanel.setBounds(0, 30, 378, 360);
        receiptPnl.add(receiptContentPanel);
        receiptContentPanel.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel totalPnl = new RoundedPanel(30, 30);
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

        AmountPanel = new RoundedPanel(30, 30);
        AmountPanel.setOpaque(false);
        AmountPanel.setBounds(180, 11, 188, 31);
        totalPnl.add(AmountPanel);

        addedPnl = new RoundedPanel(30, 30);
        addedPnl.setOpaque(false);
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

        barcodeField = new RoundedTextField(20, 20);
        barcodeField.setBounds(496, 333, 300, 30);
        contentPnl.add(barcodeField);
        barcodeField.setColumns(10);

        productField = new RoundedTextField(20, 20);
        productField.setColumns(10);
        productField.setBounds(496, 397, 300, 30);
        contentPnl.add(productField);

        priceField = new RoundedTextField(20, 20);
        priceField.setColumns(10);
        priceField.setBounds(496, 467, 300, 30);
        contentPnl.add(priceField);

        quantityField = new RoundedTextField(20, 20);
        quantityField.setColumns(10);
        quantityField.setBounds(496, 536, 300, 30);
        contentPnl.add(quantityField);

        quantityField.addCaretListener(e -> {
            try {
                int quantity = Integer.parseInt(quantityField.getText());
                float price = Float.parseFloat(priceField.getText());
                float totalPrice = price * quantity;
                priceField.setText(String.valueOf(totalPrice));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        JButton PrintBtn = new RoundedButton("PRINT", 20, 20);
        PrintBtn.setBounds(824, 514, 89, 51);
        contentPnl.add(PrintBtn);
        PrintBtn.addActionListener(e -> printReceipt());

        JButton btnAdd = new RoundedButton("ADD", 20, 20);
        btnAdd.addActionListener(e -> addProduct());
        btnAdd.setBounds(824, 446, 89, 51);
        contentPnl.add(btnAdd);

        JButton btnFind = new RoundedButton("Find", 20, 20);
        btnFind.addActionListener(e -> findProduct());
        btnFind.setBounds(806, 333, 73, 28);
        contentPnl.add(btnFind);
        
        JButton newTransaction = new JButton("New Transaction");
        newTransaction.setBounds(282, 606, 183, 23);
        contentPnl.add(newTransaction);
        newTransaction.addActionListener(e -> startNewTransaction());

    }

    private void addProduct() {
        try {
            int Barcode = Integer.parseInt(barcodeField.getText());
            String productName = productField.getText();
            float price = Float.parseFloat(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            System.out.println(Barcode + " Added");

            products newProduct = new products(Barcode, productName, price, quantity);
            productList.add(newProduct);

            // Clear input fields
            barcodeField.setText("");
            productField.setText("");
            priceField.setText("");
            quantityField.setText("1");

            // Update the table in addedPnl
            updateTable(productList);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input format.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void findProduct() {
        String barcode = barcodeField.getText();

        try {
            products product = dbHandler.getProduct(Integer.parseInt(barcode), email);

            if (product != null) {
                productField.setText(product.getProductName());
                priceField.setText(String.valueOf(product.getPrice()));
                quantityField.setText("1");
            } else {
                JOptionPane.showMessageDialog(this, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving the product.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable(List<products> productList) {
        String[] columnNames = {"Product ID", "Product Name", "Price", "Quantity"};
        Object[][] data = new Object[productList.size()][4];

        for (int i = 0; i < productList.size(); i++) {
            products p = productList.get(i);
            data[i][0] = p.getProductId();  // Correctly access product_id
            data[i][1] = p.getProductName();
            data[i][2] = p.getPrice();
            data[i][3] = p.getQuantity();    // Ensure quantity is correctly fetched
        }

        JTable table = new JTable(new javax.swing.table.DefaultTableModel(data, columnNames));
        
        // Aligning columns to right
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                /**
				 * 
				 */
				private static final long serialVersionUID = -1487328493939212663L;

				@Override
                public void setValue(Object value) {
                    setHorizontalAlignment(SwingConstants.RIGHT);
                    super.setValue(value);
                }
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        addedPnl.removeAll();
        addedPnl.setLayout(new BorderLayout());
        addedPnl.add(scrollPane, BorderLayout.CENTER);
        addedPnl.revalidate();
        addedPnl.repaint();
    }
    
    private void printReceipt() {
        // Clear the receipt panel
        receiptContentPanel.removeAll();

        // Create a new panel to hold receipt content with padding
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
        receiptPanel.setOpaque(false);

        // Create a wrapper panel for adding margins
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around edges
        wrapperPanel.add(receiptPanel, BorderLayout.NORTH);

        // Add header
        JLabel header = new JLabel("EXODUS");
        header.setFont(new Font("Times New Roman", Font.BOLD, 24));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        receiptPanel.add(header);
        
        JLayeredPane layeredPane = new JLayeredPane();
        receiptPanel.add(layeredPane);

        receiptPanel.add(Box.createVerticalStrut(15)); // Spacer below the header

        // Add product details
        float totalAmount = 0;
        for (products product : productList) {
            String productDetails = String.format("%s x%d - $%.2f", 
                product.getProductName(), product.getQuantity(), product.getPrice());
            JLabel productLabel = new JLabel(productDetails);
            productLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
            productLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Center-align the text
            receiptPanel.add(productLabel);

            // Add some spacing between product lines
            receiptPanel.add(Box.createVerticalStrut(10));

            // Calculate total
            totalAmount += product.getPrice();
        }

        receiptPanel.add(Box.createVerticalStrut(20)); // Spacer below the content

        // Add footer
        JLabel footer = new JLabel("Thank You for shopping with us!");
        footer.setFont(new Font("Tahoma", Font.ITALIC, 14));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        receiptPanel.add(footer);

        // Add the wrapper panel to the receiptContentPanel
        receiptContentPanel.setLayout(new BorderLayout());
        receiptContentPanel.add(wrapperPanel, BorderLayout.CENTER);
        receiptContentPanel.revalidate();
        receiptContentPanel.repaint();

        // Display total in AmountPanel
        AmountPanel.removeAll();
        JLabel totalLabel = new JLabel(String.format("$ " + totalAmount));
        totalLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        AmountPanel.add(totalLabel);
        AmountPanel.revalidate();
        AmountPanel.repaint();
    }
    
    private void startNewTransaction() {
        // Clear the receipt content panel
        receiptContentPanel.removeAll();
        receiptContentPanel.revalidate();
        receiptContentPanel.repaint();

        // Clear the added panel
        addedPnl.removeAll();
        addedPnl.revalidate();
        addedPnl.repaint();

        // Clear the product list
        productList.clear();

        // Reset the amount panel
        AmountPanel.removeAll();
        AmountPanel.revalidate();
        AmountPanel.repaint();

        JOptionPane.showMessageDialog(this, "Transaction cleared. Ready for a new transaction.", "New Transaction", JOptionPane.INFORMATION_MESSAGE);
    }


}
