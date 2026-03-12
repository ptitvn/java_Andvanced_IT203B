package HN_KS24_CNTT5_LeTrungDong;

import java.util.Scanner;

public class ConsoleUI {
    private final ProductService service = new ProductService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("""
                     ========= PRODUCT MANAGEMENT SYSTEM =========
                     1. Thêm sản phẩm mới
                     2. Hiển thị danh sách sản phẩm
                     3. Cập nhật số lượng theo ID;
                     4. Xóa sản phẩm đã hết hàng
                     5. Thoát chương trình
                    Lựa chọn của bạn: """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> displayProducts();
                    case 3 -> updateQuantity();
                    case 4 -> service.deleteOutOfStock();
                    case 5 -> {
                        System.out.println("Thoát chương trình.");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (InvalidProductException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private void addProduct() throws InvalidProductException {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Giá: ");
        double price = scanner.nextDouble();

        System.out.print("Số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Danh mục: ");
        String category = scanner.nextLine();

        Product product = new Product(id, name, price, quantity, category);
        service.addProduct(product);
    }

    private void displayProducts() {
        System.out.println("| ID    | Tên sản phẩm     | Giá        | Số lượng | Danh mục   |");
        System.out.println("---------------------------------------------------------------");
        service.getAllProducts().forEach(System.out::println);
    }

    private void updateQuantity() throws InvalidProductException {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = scanner.nextInt();

        System.out.print("Nhập số lượng mới: ");
        int quantity = scanner.nextInt();
        service.updateQuantity(id, quantity);
    }

}
