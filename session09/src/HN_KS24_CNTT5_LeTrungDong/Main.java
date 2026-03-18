package HN_KS24_CNTT5_LeTrungDong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("""
                    ------- QUẢN LÝ SẢN PHẨM -------
                    1. Thêm mới sản phẩm
                    2. Xem danh sách sản phẩm
                    3. Cập nhật thông tin sản phẩm
                    4. Xóa sản phẩm
                    5. Thoát
                    Lựa chọn của bạn: """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Loại sản phẩm (1-Physical, 2-Digital): ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Giá: ");
                    double price = sc.nextDouble();
                    System.out.print(type == 1 ? "Trọng lượng: " : "Dung lượng(MB): ");
                    double extra = sc.nextDouble();

                    Product p = ProductFactory.createProduct(type, id, name, price, extra);
                    db.addProduct(p);
                    break;

                case 2:
                    db.displayAllProducts();
                    break;

                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = sc.nextLine();
                    System.out.print("Loại sản phẩm (1-Physical, 2-Digital): ");
                    int updateType = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tên mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Giá mới: ");
                    double newPrice = sc.nextDouble();
                    System.out.print(updateType == 1 ? "Trọng lượng mới: " : "Dung lượng mới(MB): ");
                    double newExtra = sc.nextDouble();

                    Product newProduct = ProductFactory.createProduct(updateType, updateId, newName, newPrice, newExtra);
                    db.updateProduct(updateId, newProduct);
                    break;

                case 4:
                    System.out.print("Loại sản phẩm cần xóa (1-Physical, 2-Digital): ");
                    int delType = sc.nextInt(); sc.nextLine();
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deleteId = sc.nextLine();
                    db.deleteProduct(delType, deleteId);
                    break;

                case 5:
                    System.out.println("Thoát chương trình...");
                    return;
            }
        }
    }
}
