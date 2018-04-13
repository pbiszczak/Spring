package com.knowledgerepository.front.controller;


import com.knowledgerepository.back.model.BasketModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BasketController {


    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(@ModelAttribute("basket") BasketModel basketModel, Model model) {

        model.addAttribute("title", "Basket");
        model.addAttribute("basketItems", basketModel.getItems());

        model.addAttribute("userClickBasket", true);
        return "page";
    }

    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @RequestMapping(value = "/basket/add/{id}", method = RequestMethod.GET)
    public String addItemToBasket(@PathVariable("id") int id, @RequestParam("formProductCount") int quantity, @ModelAttribute("basket") BasketModel basketModel, Model model) {

        basketModel.udpdateBasketWithNewProduct(id, quantity);

        model.addAttribute("title", "Basket");
        model.addAttribute("basketItems", basketModel.getItems());

        model.addAttribute("userClickBasket", true);
        return "page";
    }

}
