package btth.dao;

import java.sql.*;
import java.util.List;

public class OrderDAO {

    public int createOrder(int userId, Connection conn) throws SQLException {
        String sql = "INSERT INTO orders(user_id) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, userId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        throw new SQLException("Cannot create order");
    }

    // Batch insert
    public void insertOrderDetailsBatch(int orderId, List<Integer> productIds,
                                        List<Integer> quantities,
                                        List<Double> prices,
                                        Connection conn) throws SQLException {

        String sql = "INSERT INTO order_details(order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < productIds.size(); i++) {
                ps.setInt(1, orderId);
                ps.setInt(2, productIds.get(i));
                ps.setInt(3, quantities.get(i));
                ps.setDouble(4, prices.get(i));

                ps.addBatch();
            }

            ps.executeBatch();
        }
    }
}