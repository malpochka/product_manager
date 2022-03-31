package by.itsupportme.product_manager.interfaces;

import by.itsupportme.product_manager.model.Product;
import by.itsupportme.product_manager.model.RetailerType;

import java.util.List;

public interface ProductService {
    List<Product> findAllByTitleAndDescription(String title);

    void saveProduct(Product product);

    void saveAllProducts(List<Product> products);

    void deleteProduct(Long productId);

    void addNewProducts();

    List<Product> findAllByRetailer(RetailerType retailer);
}
