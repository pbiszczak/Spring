package com.knowledgerepository.back.model;

import com.knowledgerepository.back.entity.Product;
import com.knowledgerepository.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketModel {

    private double totalPayment;

    private int numberOfItems;

    private List<BasketItemModel> basketItems;


    private ProductService productService;

    public BasketModel() {
        this.totalPayment = 0;
        this.numberOfItems = 0;
        this.basketItems = new ArrayList<>();

    }

    public ProductService getProductService() {
        return productService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }


    public List<BasketItemModel> getItems() {
        return basketItems;
    }

    public void updateTotalPayment() {
        this.totalPayment = 0;
        for (BasketItemModel basketItem : basketItems) {
            this.totalPayment += basketItem.getTotalPayment();
        }
    }

    public void addItemToBasketItemsList(int productId, int quantity) {

        for (BasketItemModel basketItem : basketItems) {
            if (basketItem.getProduct().getId() == productId) {
                basketItem.setProductCount(basketItem.getProductCount() + quantity);
                return;
            }
        }

        BasketItemModel basketItemModel = new BasketItemModel();

        Product product = productService.findProductById(productId);

        basketItemModel.setProduct(product);
        basketItemModel.setProductCount(quantity);
        basketItemModel.setPrice(product.getPrice());
        basketItemModel.updateTotalPayment();

        this.basketItems.add(basketItemModel);
    }


}