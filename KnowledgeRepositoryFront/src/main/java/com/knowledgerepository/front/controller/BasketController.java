package com.knowledgerepository.front.controller;


import com.knowledgerepository.back.model.BasketModel;
import com.knowledgerepository.front.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasketController {

    private final FrontService frontService;

    @Autowired
    public BasketController(FrontService frontService) {
        this.frontService = frontService;
    }


    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(Model model) {

        model.addAttribute("title", "Basket");
        model.addAttribute("basketItems", frontService.getBasketModel().getItems());

        model.addAttribute("userClickBasket", true);
        return "page";
    }

    @RequestMapping(value = "/basket/add/{id}", method = RequestMethod.GET)
    public String addItemToBasket(@PathVariable("id") int id, Model model) {

        BasketModel basketModel = frontService.addItemToBasketModel(id);

        model.addAttribute("title", "Basket");
        model.addAttribute("basketItems", basketModel.getItems());
        model.addAttribute(frontService.getBasketModelAttributeName(), basketModel);

        model.addAttribute("userClickBasket", true);
        return "page";
    }

}
