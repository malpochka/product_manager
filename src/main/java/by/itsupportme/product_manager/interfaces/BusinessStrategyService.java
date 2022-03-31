package by.itsupportme.product_manager.interfaces;

import by.itsupportme.product_manager.model.Product;
import by.itsupportme.product_manager.model.RetailerType;

import java.util.List;

public interface BusinessStrategyService {
    void changeStockLevel(List<Product> products, RetailerType retailer);
}
