package HN_KS24_CNTT5_LeTrungDong;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) throws InvalidProductException {
        boolean exists = products.stream().anyMatch(p -> p.getId() == product.getId());
        if (exists) throw new InvalidProductException("ID sản phẩm đã tồn tại.");
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void updateQuantity(int id, int newQuantity) throws InvalidProductException {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new InvalidProductException("Không tìm thấy sản phẩm có ID này."));
        product.setQuantity(newQuantity);
    }

    public void deleteOutOfStock() {
        products = products.stream()
                .filter(p -> p.getQuantity() > 0)
                .collect(Collectors.toList());
    }
}
