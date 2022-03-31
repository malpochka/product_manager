package by.itsupportme.product_manager.controller;

import by.itsupportme.product_manager.factory.RetailerFactory;
import by.itsupportme.product_manager.interfaces.BusinessStrategyService;
import by.itsupportme.product_manager.interfaces.RetailerService;
import by.itsupportme.product_manager.model.Product;
import by.itsupportme.product_manager.model.RetailerType;
import by.itsupportme.product_manager.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;
    private final BusinessStrategyService businessStrategyService;

    public ProductController(ProductService productService, BusinessStrategyService businessStrategyService) {
        this.productService = productService;
        this.businessStrategyService = businessStrategyService;
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PostMapping("/products/{retailer}")
    public List<Product> findAllProductsByRetailer(@PathVariable("retailer") RetailerType retailer) {
        List<Product> products = productService.findAllByRetailer(retailer);
        businessStrategyService.changeStockLevel(products,retailer);
        productService.saveAllProducts(products);
        return products;
    }

    @GetMapping("/products")
    public List<Product> findAllProductsByTitle(@RequestParam(value = "title") String title) {
        return productService.findAllByTitleAndDescription(title);
    }
}
