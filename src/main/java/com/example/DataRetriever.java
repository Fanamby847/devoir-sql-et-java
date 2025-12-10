package main.java.com.example;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private DBConnection db = new DBConnection();

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();

        String sql = "SELECT id, name FROM product_category";

        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductList(int page, int size) {
        List<Product> list = new ArrayList<>();

        int offset = (page - 1) * size;
        String sql = "SELECT * FROM product LIMIT ? OFFSET ?";

        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, size);
            stmt.setInt(2, offset);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getTimestamp("creation_datetime").toInstant()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductsByName(String productName) {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM product WHERE name ILIKE ?";

        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + productName + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getTimestamp("creation_datetime").toInstant()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}