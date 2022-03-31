package by.itsupportme.product_manager.model;

import javax.persistence.*;

@Entity
public class Product extends AbstractEntity {

    private String title;
    private String description;
    private int stockLevel;

    @Enumerated(EnumType.ORDINAL)
    private RetailerType retailer;

    public Product() {
    }

    public Product(String title, String description, int stockLevel, RetailerType retailer) {
        this.title = title;
        this.description = description;
        this.stockLevel = stockLevel;
        this.retailer = retailer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public RetailerType getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerType retailer) {
        this.retailer = retailer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
