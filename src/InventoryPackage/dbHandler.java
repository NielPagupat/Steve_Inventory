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
    public static void createProduct(products product, String owner) throws SQLException {
        String query = "INSERT INTO product_table (owner, product_id, product_name, price, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

        	pstmt.setString(1, owner);
        	pstmt.setInt(2, product.getProductId());
            pstmt.setString(3, product.getProductName());
            pstmt.setFloat(4, product.getPrice());
            pstmt.setInt(5, product.getStock());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) added.");
        }
    }

    // Read (Retrieve) all products
    public static List<products> getDataFromDB(String owner) throws SQLException {
        String query = "SELECT * FROM product_table WHERE owner = '" + owner +"'";
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
    public static void updateProduct(products product, String owner) throws SQLException {
        String query = "UPDATE product_table SET product_name = ?, price = ?, stock = ? WHERE product_id = ? AND owner = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setFloat(2, product.getPrice());
            pstmt.setInt(3, product.getStock());
            pstmt.setInt(4, product.getProductId());
            pstmt.setString(5, owner);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) updated.");
        }
    }

    // Delete a product by ID
    public static void deleteProduct(int productId, String owner) throws SQLException {
        String query = "DELETE FROM product_table WHERE product_id = ? AND owner = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, productId);
            pstmt.setString(2, owner);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " product(s) deleted.");
        }
    }
    
 // Register a new user
    public static boolean registerUser(user newUser) throws SQLException {
        String query = "INSERT INTO users (email, password, first_name, last_name, business_name) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getBusinessName());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if a user was successfully registered
        }
    }

    // Log in a user
    public static boolean loginUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // If a row is found, credentials are valid
            }
        }
    }

    // Change password
    public static boolean changePassword(String email, String newPassword) throws SQLException {
        String query = "UPDATE users SET password = ? WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if the password was successfully updated
        }
    }

    // Update user attributes (except email)
    public static boolean updateUser(String email, String firstName, String lastName, String businessName) throws SQLException {
        String query = "UPDATE users SET first_name = ?, last_name = ?, business_name = ? WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, businessName);
            pstmt.setString(4, email);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if user attributes were successfully updated
        }
    }
}
