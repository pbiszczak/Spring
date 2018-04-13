package com.knowledgerepository.front.controller;

import com.knowledgerepository.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private final CategoryService categoryService;

    @Autowired
    public PageController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("userClickHome", true);

        model.addAttribute("categories", categoryService.findAllCategories());

        return "page";
    }

    @RequestMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("title", "About Us");
        model.addAttribute("userClickAbout", true);
        return "page";
    }

    @RequestMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact Us");
        model.addAttribute("userClickContact", true);
        return "page";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("userClickLogin", true);
        return "page";
    }



}
