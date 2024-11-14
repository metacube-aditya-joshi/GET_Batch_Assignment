package jdbc;

import java.net.ConnectException;
import java.sql.*;

public class SQL_Queries {
    Connection connection;

    public void dbConnection() throws ClassNotFoundException, SQLException, ConnectException {
        try {
            String host = "jdbc:mysql://localhost:3306/";
            String dbName = "dbms_assignment";

            String mySqlURI = host + dbName;
            String userId = "root";
            String password = "root";
            System.out.println(mySqlURI);

            connection = DriverManager.getConnection(mySqlURI, userId, password);

            System.out.println("Connection established at uri : " + mySqlURI);
        } catch (SQLException e) {
            System.out.println("Error loading driver: " + e);
            throw new ClassNotFoundException(e.getMessage());
        }
    }

    public void assignment1(int user_id) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT o.id, o.order_date, o.order_total " +
                        "FROM orders o " +
                        "JOIN users u ON o.? = u.? " +
                        "WHERE o.status = 'shipped' " +
                        "ORDER BY o.order_date ASC")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("");
                Timestamp orderDate = rs.getTimestamp("order_date");
                double orderTotal = rs.getDouble("order_total");
                System.out.println(
                        "Order ID: " + orderId + ", Order Date: " + orderDate + ", Order Total: " + orderTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignment2() {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO images (image_id, image_url) VALUES (?, ?)");

            PreparedStatement countStmt = connection.prepareStatement(
                    "SELECT MAX(image_id) FROM images");

            ResultSet rs = countStmt.executeQuery();
            System.out.println(rs);
            int nextImageId = 1;
            if (rs.next()) {
                nextImageId = rs.getInt(1) + 1;
            }

            String[] imageUrls = {
                    "product1_image1.jpg",
                    "product1_image2.jpg",
                    "product1_image3.jpg",
                    "product1_image4.jpg",
                    "product1_image5.jpg"
            };

            for (String imageUrl : imageUrls) {
                stmt.setInt(1, nextImageId);
                stmt.setString(2, imageUrl);
                stmt.addBatch();
                nextImageId++;
            }

            stmt.executeBatch();

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
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT c.parent_category as name , count(c.name) as child_count " +
                            "from category c " +
                            " where c.name NOT IN (select parent_category from category where parent_category LIKE \"Top Category\") "
                            +
                            " GROUP BY c.parent_category;");
            stmt.addBatch();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String categoryTitle = rs.getString("name");
                int childCount = rs.getInt("child_count");
                System.out.println("Category Title: " + categoryTitle + ", Child Count: " + childCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}