package by.itsupportme.product_manager.service;

import by.itsupportme.product_manager.factory.RetailerFactory;
import by.itsupportme.product_manager.interfaces.BusinessStrategyService;
import by.itsupportme.product_manager.interfaces.ProductService;
import by.itsupportme.product_manager.interfaces.RetailerService;
import by.itsupportme.product_manager.model.Product;
import by.itsupportme.product_manager.model.RetailerType;
import by.itsupportme.product_manager.repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.itsupportme.product_manager.util.Constant.*;

@Service
public class ProductServiceImpl implements ProductService, BusinessStrategyService {

    private final ProductRepository productRepository;
    private final RetailerFactory retailerFactory;

    public ProductServiceImpl(ProductRepository productRepository, RetailerFactory retailerFactory) {
        this.productRepository = productRepository;
        this.retailerFactory = retailerFactory;
    }

    @Override
    public List<Product> findAllByTitleAndDescription(String title) {
        return productRepository.findByTitleContainingOrDescriptionContainsIgnoreCase(title, title);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void saveAllProducts(List<Product> products) {
        productRepository.saveAll(products);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    @Scheduled(fixedRate = FIVE_MINUTES)
    public void addNewProducts() {
        Product firstProduct = new Product(RANDOM_PRODUCT, DESCRIPTION_PRODUCT, NUMBERS_PRODUCT, RetailerType.RETB);
        Product secondProduct = new Product(RANDOM_BELT, DESCRIPTION_BELT, NUMBERS_BELT, RetailerType.RETA);
        Product thirdProduct = new Product(RANDOM_HAT, DESCRIPTION_HAT, NUMBERS_HAT, RetailerType.RETB);

        productRepository.save(firstProduct);
        productRepository.save(secondProduct);
        productRepository.save(thirdProduct);
    }

    @Override
    public List<Product> findAllByRetailer(RetailerType retailer) {
        return productRepository.findByRetailer(retailer);
    }

    @Override
    public void changeStockLevel(List<Product> products, RetailerType retailer) {
        RetailerService retailerService = retailerFactory.getRetailer(retailer);
        retailerService.businessRule(products);
    }
}

