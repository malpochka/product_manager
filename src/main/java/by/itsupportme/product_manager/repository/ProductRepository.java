package by.itsupportme.product_manager.repository;

import by.itsupportme.product_manager.model.Product;
import by.itsupportme.product_manager.model.RetailerType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByTitleContainingOrDescriptionContainsIgnoreCase(String title, String string);

    List<Product> findByRetailer(RetailerType retailer);
}
