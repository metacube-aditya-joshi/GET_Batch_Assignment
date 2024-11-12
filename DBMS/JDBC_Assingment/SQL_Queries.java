package DBMS.JDBC_Assingment;

import java.net.ConnectException;
import java.sql.*;

public class SQL_Queries {
    Connection connection;

    public void dbConnection() throws ClassNotFoundException, SQLException {
        try {
            String host = "jdbc:mysql://localhost:3306/";
            String dbName = "dbms_assignment";

            String mySqlURI = host + dbName;
            String userId = "root";
            String password = "root";
            System.out.println(mySqlURI);

            Class.forName("com.mysql.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(mySqlURI, userId, password)) {
                this.connection = connection;
                System.out.println("Connection established at uri : " + mySqlURI);
            }
        } catch (SQLException e) {
            System.out.println("Error loading driver: " + e);
            throw new ClassNotFoundException(e.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
            throw new ClassNotFoundException(cnfe.getMessage());
        }
    }

    public void assignment1() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT o.id, o.order_date, o.order_total " +
                "FROM orders o " +
                "JOIN users u ON o.user_id = u.id " +
                "WHERE o.status = 'shipped' " +
                "ORDER BY o.order_date ASC")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                Timestamp orderDate = rs.getTimestamp("order_date");
                double orderTotal = rs.getDouble("order_total");
                System.out.println("Order ID: " + orderId + ", Order Date: " + orderDate + ", Order Total: " + orderTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignment2() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO images (product_id, image_url) " +
                "VALUES (?, ?)")) {
            stmt.setInt(1, 1);
            stmt.setString(2, "product1_image1.jpg");
            stmt.executeUpdate();
            stmt.setString(2, "product1_image2.jpg");
            stmt.executeUpdate();
            stmt.setString(2, "product1_image3.jpg");
            stmt.executeUpdate();
            stmt.setString(2, "product1_image4.jpg");
            stmt.executeUpdate();
            stmt.setString(2, "product1_image5.jpg");
            stmt.executeUpdate();
            System.out.println("Images inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignment3() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM products " +
                "WHERE product_id NOT IN (" +
                "    SELECT DISTINCT product_id " +
                "    FROM orders " +
                "    WHERE order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)" +
                ")")) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Number of products deleted: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void assignment4() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT c.title, COUNT(c2.category_id) AS child_count " +
                "FROM category c " +
                "LEFT JOIN category c2 ON c.category_id = c2.parent_id " +
                "WHERE c.parent_id IS NULL " +
                "GROUP BY c.title " +
                "ORDER BY c.title ASC")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String categoryTitle = rs.getString("title");
                int childCount = rs.getInt("child_count");
                System.out.println("Category Title: " + categoryTitle + ", Child Count: " + childCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}