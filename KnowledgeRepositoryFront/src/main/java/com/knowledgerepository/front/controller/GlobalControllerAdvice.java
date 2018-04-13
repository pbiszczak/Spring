package com.knowledgerepository.front.controller;


import com.knowledgerepository.back.model.BasketModel;
import com.knowledgerepository.back.model.ListProductsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
@SessionAttributes({"basket", "listProductsForm"})
public class GlobalControllerAdvice {


    private final BasketModel basket;
    private final ListProductsForm listProductsForm;

    @Autowired
    public GlobalControllerAdvice(BasketModel basket, ListProductsForm listProductsForm) {
        this.basket = basket;
        this.listProductsForm = listProductsForm;
    }

    @ModelAttribute("basket")
    public BasketModel getBasket() {
        return basket;
    }

    @ModelAttribute("listProductsForm")
    public ListProductsForm getListProductsForm() {
        return listProductsForm;
    }

}
