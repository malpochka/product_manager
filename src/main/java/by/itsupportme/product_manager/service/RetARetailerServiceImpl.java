package by.itsupportme.product_manager.service;

import by.itsupportme.product_manager.interfaces.RetailerService;
import by.itsupportme.product_manager.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.itsupportme.product_manager.util.Constant.RETA_STRATEGY;

@Service
public class RetARetailerServiceImpl implements RetailerService {

    @Override
    public void businessRule(List<Product> products) {
        for (Product product : products) {
            int count = product.getStockLevel() + RETA_STRATEGY;
            product.setStockLevel(count);
        }
    }
}
