package HN_KS24_CNTT5_LeTrungDong;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<PhysicalProduct> physicalProducts;
    private List<DigitalProduct> digitalProducts;

    private ProductDatabase() {
        physicalProducts = new ArrayList<>();
        digitalProducts = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    // Thêm sản phẩm
    public boolean addProduct(Product p) {
        if (p instanceof PhysicalProduct) {
            for (PhysicalProduct prod : physicalProducts) {
                if (prod.getId().equals(p.getId())) {
                    System.out.println(" ID đã tồn tại trong PhysicalProduct!");
                    return false;
                }
            }
            physicalProducts.add((PhysicalProduct) p);
            System.out.println("Thêm PhysicalProduct thành công!");
            return true;
        } else if (p instanceof DigitalProduct) {
            for (DigitalProduct prod : digitalProducts) {
                if (prod.getId().equals(p.getId())) {
                    System.out.println("ID đã tồn tại trong DigitalProduct!");
                    return false;
                }
            }
            digitalProducts.add((DigitalProduct) p);
            System.out.println(" Thêm DigitalProduct thành công!");
            return true;
        }
        return false;
    }

    // Cập nhật sản phẩm
    public void updateProduct(String id, Product newProduct) {
        if (newProduct instanceof PhysicalProduct) {
            for (int i = 0; i < physicalProducts.size(); i++) {
                if (physicalProducts.get(i).getId().equals(id)) {
                    physicalProducts.set(i, (PhysicalProduct) newProduct);
                    System.out.println(" Cập nhật PhysicalProduct thành công!");
                    return;
                }
            }
            System.out.println(" Không tìm thấy PhysicalProduct với ID: " + id);
        } else if (newProduct instanceof DigitalProduct) {
            for (int i = 0; i < digitalProducts.size(); i++) {
                if (digitalProducts.get(i).getId().equals(id)) {
                    digitalProducts.set(i, (DigitalProduct) newProduct);
                    System.out.println(" Cập nhật DigitalProduct thành công!");
                    return;
                }
            }
            System.out.println(" Không tìm thấy DigitalProduct với ID: " + id);
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int type, String id) {
        if (type == 1) {
            boolean removed = physicalProducts.removeIf(p -> p.getId().equals(id));
            System.out.println(removed ? "Xóa PhysicalProduct thành công!" : " Không tìm thấy PhysicalProduct với ID: " + id);
        } else if (type == 2) {
            boolean removed = digitalProducts.removeIf(p -> p.getId().equals(id));
            System.out.println(removed ? "Xóa DigitalProduct thành công!" : " Không tìm thấy DigitalProduct với ID: " + id);
        }
    }

    // Lấy danh sách sản phẩm
    public void displayAllProducts() {
        System.out.println("\n--- Danh sách PhysicalProduct ---");
        for (PhysicalProduct p : physicalProducts) {
            p.displayInfo();
        }
        System.out.println("\n--- Danh sách DigitalProduct ---");
        for (DigitalProduct d : digitalProducts) {
            d.displayInfo();
        }
    }
}


