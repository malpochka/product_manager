package by.itsupportme.product_manager.service;

import by.itsupportme.product_manager.interfaces.RetailerService;
import by.itsupportme.product_manager.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.itsupportme.product_manager.util.Constant.RETB_STRATEGY;

@Service
public class RetBRetailerServiceImpl implements RetailerService {

    @Override
    public void businessRule(List<Product> products) {
        for (Product product : products) {
            int count = product.getStockLevel() + RETB_STRATEGY;
            product.setStockLevel(count);
        }
    }
}
