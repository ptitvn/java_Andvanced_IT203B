package ra.presentation;

import ra.business.TransactionBusiness;
import ra.entity.Transaction;

import java.util.Scanner;

public class FundManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransactionBusiness business = TransactionBusiness.getInstance();

        while (true) {
            System.out.println("\n===== QUẢN LÝ QUỸ =====");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. VIP");
            System.out.println("7. Sắp xếp");
            System.out.println("8. Thống kê");
            System.out.println("9. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    business.displayAll();
                    break;

                case 2:
                    do {
                        Transaction t = new Transaction();
                        t.inputData(sc);

                        if (business.addTransaction(t)) {
                            System.out.println("Thêm thành công!");
                        }

                        System.out.print("Thêm tiếp? (y/n): ");
                    } while (sc.nextLine().equalsIgnoreCase("y"));
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    business.update(sc.nextLine(), sc);
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    business.delete(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    business.searchByName(sc.nextLine());
                    break;

                case 6:
                    business.filterVIP();
                    break;

                case 7:
                    business.sortDesc();
                    break;

                case 8:
                    business.statistics();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}