package ra.business;

import ra.entity.Transaction;

import java.util.*;

public class TransactionBusiness {
    private static TransactionBusiness instance;
    private List<Transaction> transactions;

    private TransactionBusiness() {
        transactions = new ArrayList<>();
    }

    public static TransactionBusiness getInstance() {
        if (instance == null) {
            instance = new TransactionBusiness();
        }
        return instance;
    }

    // 1. Hiển thị
    public void displayAll() {
        if (transactions.isEmpty()) {
            System.out.println("Quỹ chưa có giao dịch!");
            return;
        }
        System.out.printf("%-10s | %-20s | %-30s | %s\n",
                "ID", "Tên", "Lời nhắn", "Tiền");
        transactions.forEach(Transaction::displayData);
    }

    // 2. Thêm
    public boolean addTransaction(Transaction t) {
        boolean exists = transactions.stream()
                .anyMatch(tr -> tr.getTransactionId().equals(t.getTransactionId()));

        if (exists) {
            System.out.println("Mã GD bị trùng!");
            return false;
        }
        transactions.add(t);
        return true;
    }

    // 3. Cập nhật
    public void update(String id, Scanner sc) {
        Optional<Transaction> opt = transactions.stream()
                .filter(t -> t.getTransactionId().equals(id))
                .findFirst();

        if (!opt.isPresent()) {
            System.out.println("Không tìm thấy!");
            return;
        }

        Transaction t = opt.get();

        System.out.print("Nhập tên mới: ");
        t.setStudentName(sc.nextLine());

        System.out.print("Nhập lời nhắn mới: ");
        t.setMessage(sc.nextLine());
    }

    // 4. Xóa
    public void delete(String id) {
        boolean removed = transactions.removeIf(t -> t.getTransactionId().equals(id));
        if (!removed) {
            System.out.println("Không tìm thấy để xóa!");
        }
    }

    // 5. Tìm kiếm
    public void searchByName(String name) {
        List<Transaction> result = transactions.stream()
                .filter(t -> t.getStudentName().toLowerCase()
                        .contains(name.toLowerCase()))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(Transaction::displayData);
        }
    }

    // 6. VIP > 250k
    public void filterVIP() {
        List<Transaction> result = transactions.stream()
                .filter(t -> t.getAmount() > 250000)
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không có ai trong hội VIP!");
        } else {
            result.forEach(Transaction::displayData);
        }
    }

    // 7. Sắp xếp
    public void sortDesc() {
        transactions.sort((a, b) -> Double.compare(b.getAmount(), a.getAmount()));
        System.out.println("Đã sắp xếp giảm dần!");
    }

    // 8. Thống kê
    public void statistics() {
        if (transactions.isEmpty()) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }

        double total = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount));

        System.out.println("Tổng quỹ: " + total);

        max.ifPresent(t -> System.out.println("Top đóng góp: "
                + t.getStudentName() + " - " + t.getAmount()));
    }
}
