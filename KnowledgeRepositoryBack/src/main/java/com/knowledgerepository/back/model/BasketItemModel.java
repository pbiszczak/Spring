package com.knowledgerepository.back.model;

import com.knowledgerepository.back.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class BasketItemModel {

    private int productCount;

    private double price;

    private double totalPayment;

    private Product product;

    public BasketItemModel() {
        this.productCount = 0;
        this.price = 0;
        this.totalPayment = 0;
    }


    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void updateTotalPayment() {
        this.totalPayment = this.productCount * this.price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
