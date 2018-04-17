package com.knowledgerepository.back.model;

import com.knowledgerepository.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    public List<BasketItemModel> getBasketItems() {
        return basketItems;
    }


    private void updateTotalPayment() {
        this.totalPayment = 0;
        for (BasketItemModel basketItem : basketItems) {
            this.totalPayment += basketItem.getTotalPayment();
        }
    }

    @Secured("ROLE_USER")
    public void udpdateBasketWithNewProduct(int productId, int productCount) {

        addBasketItemIfNotExist(productId);
        updateProductCountAndPriceAndTotalPayment(productId, productCount);
        updateTotalPayment();
        increaseItemsNumber(productCount);

    }

    private void updateProductCountAndPriceAndTotalPayment(int productId, int productCount) {

        BasketItemModel basketItemModel = findBasketItemOnList(productId);
        if (basketItemModel != null) {
            basketItemModel.updateProductCount(productCount);
            basketItemModel.updateProductPriceAndTotalPayment();
        }
    }


    private void addBasketItemIfNotExist(int productId) {
        if (!checkIfBasketItemIsAlredyOnList(productId)) {
            setProductAndAddItemToBasketItems(productId);
        }
    }

    private void setProductAndAddItemToBasketItems(int productId) {

        BasketItemModel basketItemModel = new BasketItemModel();
        basketItemModel.setProduct(productService.findProductById(productId));

        this.basketItems.add(basketItemModel);

    }


    private BasketItemModel findBasketItemOnList(int productId) {
        for (BasketItemModel basketItem : basketItems) {
            if (basketItem.getProduct().getId() == productId) {
                return basketItem;
            }
        }
        return null;
    }

    private boolean checkIfBasketItemIsAlredyOnList(int productId) {

        for (BasketItemModel basketItem : basketItems) {
            if (basketItem.getProduct().getId() == productId) {
                return true;
            }
        }
        return false;
    }

    private void increaseItemsNumber(int numberOfItems) {
        this.numberOfItems += numberOfItems;
    }


}