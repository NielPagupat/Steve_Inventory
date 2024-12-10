package InventoryPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/inventory";
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // Set your MySQL password here

    // Load the MySQL driver (only needs to be done once)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
            e.printStackTrace();
        }
    }

    // Create (Insert) a new product
    public static void createProduct(products product) throws SQLException {
        String query = "INSERT INTO product_table (product_id, product_name, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, product.getProductId());
            pstmt.setString(2, product.getProductName());
            pstmt.setFloat(3, product.getPrice());
            pstmt.setInt(4, product.getStock());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) added.");
        }
    }

    // Read (Retrieve) all products
    public static List<products> getDataFromDB() throws SQLException {
        String query = "SELECT * FROM product_table";
        List<products> productList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                productList.add(new products(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getFloat("price"),
                        rs.getInt("stock")
                ));
            }
        }
        return productList;
    }

    // Update an existing product
    public static void updateProduct(products product) throws SQLException {
        String query = "UPDATE product_table SET product_name = ?, price = ?, stock = ? WHERE product_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setFloat(2, product.getPrice());
            pstmt.setInt(3, product.getStock());
            pstmt.setInt(4, product.getProductId());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) updated.");
        }
    }

    // Delete a product by ID
    public static void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM product_table WHERE product_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, productId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) deleted.");
        }
    }
}
