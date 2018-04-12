package com.knowledgerepository.front.controller;


import com.knowledgerepository.back.model.BasketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("basket")
public class BasketController {


    private final BasketModel basket;

    @Autowired
    public BasketController(BasketModel basket) {
        this.basket = basket;
    }

    @ModelAttribute("basket")
    public BasketModel getBasket() {
        return basket;
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(@ModelAttribute("basket") BasketModel basketModel, Model model) {

        model.addAttribute("title", "Basket");
        model.addAttribute("basketItems", basketModel.getItems());

        model.addAttribute("userClickBasket", true);
        return "page";
    }

    @RequestMapping(value = "/basket/add/{id}", method = RequestMethod.GET)
    public String addItemToBasket(@PathVariable("id") int id, @ModelAttribute("basket") BasketModel basketModel, Model model) {

        basketModel.addItemToBasketItemsList(id, 5);

        model.addAttribute("title", "Basket");
        model.addAttribute("basketItems", basketModel.getItems());

        model.addAttribute("userClickBasket", true);
        return "page";
    }

}
