package ra.entity;

import java.util.Scanner;

public class Transaction {
    private String transactionId;
    private String studentName;
    private String message;
    private double amount;

    public Transaction() {
    }

    public Transaction(String transactionId, String studentName, String message, double amount) {
        this.transactionId = transactionId;
        this.studentName = studentName;
        this.message = message;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã GD: ");
        this.transactionId = scanner.nextLine();

        do {
            System.out.print("Nhập tên người đóng góp: ");
            this.studentName = scanner.nextLine();
            if (this.studentName.trim().isEmpty()) {
                System.out.println("Tên không được để trống!");
            }
        } while (this.studentName.trim().isEmpty());

        System.out.print("Nhập lời nhắn: ");
        this.message = scanner.nextLine();

        do {
            try {
                System.out.print("Nhập số tiền (>0): ");
                this.amount = Double.parseDouble(scanner.nextLine());
                if (this.amount <= 0) {
                    System.out.println("Số tiền phải > 0!");
                }
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng!");
            }
        } while (this.amount <= 0);
    }

    public void displayData() {
        System.out.printf("%-10s | %-20s | %-30s | %.0f\n",
                transactionId, studentName, message, amount);
    }
}