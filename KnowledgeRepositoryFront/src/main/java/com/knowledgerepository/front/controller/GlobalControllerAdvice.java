package com.knowledgerepository.front.controller;


import com.knowledgerepository.front.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    private final FrontService frontService;

    @Autowired
    public GlobalControllerAdvice(FrontService frontService) {
        this.frontService = frontService;
    }

    @ModelAttribute
    public void initializeBasket(Model model) {
        System.out.println("global controller called");
        model.addAttribute(frontService.getBasketModelAttributeName(), frontService.getBasketModel());
    }
}
