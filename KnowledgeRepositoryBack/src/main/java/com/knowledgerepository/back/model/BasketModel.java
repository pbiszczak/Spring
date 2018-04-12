package com.knowledgerepository.back.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketModel {

    private double totalPayment;

    private int numberOfItems;

    private List<BasketItemModel> basketItems;

    public BasketModel() {
        this.totalPayment = 0;
        this.numberOfItems = 0;
        this.basketItems = new ArrayList<>();
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

    public void addItemToBasketItems(BasketItemModel item) {

        for (BasketItemModel basketItem : basketItems) {
            if (basketItem.getProduct() == item.getProduct()) {
                basketItem.setProductCount(basketItem.getProductCount() + item.getProductCount());
                return;
            }
        }

        this.basketItems.add(item);
    }


}