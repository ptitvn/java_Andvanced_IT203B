package bt3;

public class Main {

    public static void main(String[] args) {

        System.out.println("COD");
        PaymentProcessor p1 = new PaymentProcessor(new CODPayment());
        p1.process(500000);

        System.out.println("\nThẻ tín dụng");
        PaymentProcessor p2 = new PaymentProcessor(new CreditCardPayment());
        p2.process(1000000);

        System.out.println("\nVí MoMo");
        PaymentProcessor p3 = new PaymentProcessor(new MomoPayment());
        p3.process(750000);

        // Kiểm tra LSP
        System.out.println("\nKiểm tra LSP (thay thế implementation)");
        PaymentProcessor p4 = new PaymentProcessor(new MomoPayment());
        p4.process(750000);
    }
}
