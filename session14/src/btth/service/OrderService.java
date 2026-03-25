package btth.service;

import btth.dao.OrderDAO;
import btth.dao.ProductDAO;
import btth.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

public class OrderService {

    private final ProductDAO productDAO = new ProductDAO();
    private final OrderDAO orderDAO = new OrderDAO();

    public void placeOrder(int userId, int productId, int quantity) {
        Connection conn = null;

        try {
            conn = DatabaseConnection.getInstance().getConnection();

            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            // 1. Lock + lấy stock
            int stock = productDAO.getStockForUpdate(productId, conn);

            if (stock < quantity) {
                throw new RuntimeException("Hết hàng");
            }

            // 2. Lấy giá
            double price = productDAO.getPrice(productId, conn);

            // 3. Update stock
            productDAO.updateStock(productId, stock - quantity, conn);

            // 4. Tạo order
            int orderId = orderDAO.createOrder(userId, conn);

            // 5. Batch insert order details
            orderDAO.insertOrderDetailsBatch(
                    orderId,
                    Collections.singletonList(productId),
                    Collections.singletonList(quantity),
                    Collections.singletonList(price),
                    conn
            );

            conn.commit();
            System.out.println("[SUCCESS] User " + userId);

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
                System.out.println("[FAILED] User " + userId + " | " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}