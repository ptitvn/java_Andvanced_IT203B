package bt2;

public class Main {

    public static void main(String[] args) {

        double total = 1_000_000;

        // PercentageDiscount 10%
        OrderCalculator calculator1 =
                new OrderCalculator(new PercentageDiscount(10));

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        System.out.println("Số tiền sau giảm: " + calculator1.calculate(total));

        // FixedDiscount
        OrderCalculator calculator2 =
                new OrderCalculator(new FixedDiscount(50000));

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        System.out.println("Số tiền sau giảm: " + calculator2.calculate(total));

        // NoDiscount
        OrderCalculator calculator3 =
                new OrderCalculator(new NoDiscount());

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        System.out.println("Số tiền sau giảm: " + calculator3.calculate(total));

        // HolidayDiscount
        OrderCalculator calculator4 =
                new OrderCalculator(new HolidayDiscount());

        System.out.println("\nThêm HolidayDiscount 15% (không sửa code cũ)");
        System.out.println("Số tiền sau giảm: " + calculator4.calculate(total));
    }
}