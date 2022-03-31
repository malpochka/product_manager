package by.itsupportme.product_manager.factory;

import by.itsupportme.product_manager.interfaces.RetailerService;
import by.itsupportme.product_manager.model.RetailerType;
import by.itsupportme.product_manager.service.RetARetailerServiceImpl;
import by.itsupportme.product_manager.service.RetBRetailerServiceImpl;
import org.springframework.stereotype.Service;

import static by.itsupportme.product_manager.util.Constant.WRONG;

@Service
public class RetailerFactory {
    public RetailerService getRetailer(RetailerType retailer) {
        RetailerService retailerService = null;
        switch (retailer) {
            case RETA:
                retailerService = new RetARetailerServiceImpl();
                break;
            case RETB:
                retailerService = new RetBRetailerServiceImpl();
                break;
            default:
                throw new IllegalArgumentException(WRONG + retailerService);
        }

        return retailerService;
    }
}
