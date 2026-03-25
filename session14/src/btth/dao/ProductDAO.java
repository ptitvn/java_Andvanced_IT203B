package btth.dao;

import java.sql.*;

public class ProductDAO {

    public int getStockForUpdate(int productId, Connection conn) throws SQLException {
        String sql = "SELECT stock FROM products WHERE id = ? FOR UPDATE";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("stock");
            }
        }
        return 0;
    }

    public double getPrice(int productId, Connection conn) throws SQLException {
        String sql = "SELECT price FROM products WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
        }
        throw new SQLException("Product not found");
    }

    public void updateStock(int productId, int newStock, Connection conn) throws SQLException {
        String sql = "UPDATE products SET stock = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newStock);
            ps.setInt(2, productId);
            ps.executeUpdate();
        }
    }
}