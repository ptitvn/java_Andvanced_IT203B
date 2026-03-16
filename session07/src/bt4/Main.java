package bt4;

public class Main {

    public static void main(String[] args) {

        System.out.println("Dùng FileOrderRepository và EmailService");

        OrderRepository fileRepo = new FileOrderRepository();
        NotificationService email = new EmailService();

        OrderService orderService1 =
                new OrderService(fileRepo, email);

        orderService1.createOrder(new Order("ORD001"));

        System.out.println("\nĐổi sang DatabaseOrderRepository và SMSNotification");

        OrderRepository dbRepo = new DatabaseOrderRepository();
        NotificationService sms = new SMSNotification();

        OrderService orderService2 =
                new OrderService(dbRepo, sms);

        orderService2.createOrder(new Order("ORD002"));
    }
}