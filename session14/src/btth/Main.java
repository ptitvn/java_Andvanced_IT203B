package btth;

import btth.service.OrderService;
import btth.service.ReportService;

public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        ReportService reportService = new ReportService();

        // TEST FLASH SALE
        for (int i = 1; i <= 50; i++) {
            int userId = i;

            new Thread(() -> {
                orderService.placeOrder(userId, 1, 1);
            }).start();
        }

        // đợi thread xong
        try {
            Thread.sleep(5000);
        } catch (Exception e) {}

        // REPORT
        reportService.getTopBuyers();
        reportService.getRevenueByCategory(1);
    }
}