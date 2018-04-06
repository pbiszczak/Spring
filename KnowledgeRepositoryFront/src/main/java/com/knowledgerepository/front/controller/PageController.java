package com.knowledgerepository.front.controller;

import com.knowledgerepository.back.entity.Category;
import com.knowledgerepository.back.service.CategoryService;
import com.knowledgerepository.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public PageController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @RequestMapping(value = {"/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("userClickHome", true);

        model.addAttribute("categories", categoryService.findAllCategories());

        return "page";
    }

    @RequestMapping(value = {"/about"})
    public String about(Model model) {
        model.addAttribute("title", "About Us");
        model.addAttribute("userClickAbout", true);
        return "page";
    }

    @RequestMapping(value = {"/contact"})
    public String contact(Model model) {
        model.addAttribute("title", "Contact Us");
        model.addAttribute("userClickContact", true);
        return "page";
    }


    @RequestMapping(value = {"/products/all"})
    public String showAllProducts(Model model) {

        model.addAttribute("title", "All Products");
        model.addAttribute("categories", categoryService.findAllCategories());

        List products = productService.findAllProducts();
        model.addAttribute("products", products);

        model.addAttribute("userClickAllProducts", true);

        return "page";
    }

    @RequestMapping(value = {"/products/category/{id}"})
    public String showCategoryProducts(@PathVariable("id") int id, Model model) {


        // categoryService to fetch a single category
        Category category = categoryService.findCategoryById(id);

        model.addAttribute("title", category.getName());
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("category", category);

        List products = productService.findProductsByCategory(id);
        model.addAttribute("products", products);

        model.addAttribute("userClickCategoryProducts", true);
        return "page";
    }

}
