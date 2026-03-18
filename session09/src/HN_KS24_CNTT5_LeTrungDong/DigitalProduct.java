package HN_KS24_CNTT5_LeTrungDong;

public class DigitalProduct extends Product {
    private double sizeMB;

    public DigitalProduct(String id, String name, double price, double sizeMB) {
        super(id, name, price);
        this.sizeMB = sizeMB;
    }

    @Override
    public void displayInfo() {
        System.out.println("Digital Product - ID: " + id + ", Name: " + name +
                ", Price: " + price + ", Size: " + sizeMB + "MB");
    }
}
