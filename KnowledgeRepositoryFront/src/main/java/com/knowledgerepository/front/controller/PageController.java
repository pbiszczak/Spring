package com.knowledgerepository.front.controller;

import com.knowledgerepository.back.entity.Category;
import com.knowledgerepository.back.entity.Product;
import com.knowledgerepository.back.service.CategoryService;
import com.knowledgerepository.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    private final int PAGE_SIZE = 2;
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

    @RequestMapping(value = "/products/all/page/{pageNumber}", method = RequestMethod.GET)
    public String showAllProductsPagination(@PathVariable Integer pageNumber, Model model) {




        PagedListHolder<Product> page = new PagedListHolder<>(productService.findAllProducts());
        page.setPageSize(PAGE_SIZE);
        page.setPage(pageNumber - 1);

        int current = page.getPage() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getPageCount());
        String urlPath = "/products/all/page/";

        model.addAttribute("title", "All Products");
        model.addAttribute("categories", categoryService.findAllCategories());

        model.addAttribute("products", page.getPageList());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("pageCount", page.getPageCount());

        model.addAttribute("urlPath", urlPath);

        model.addAttribute("userClickAllProducts", true);

        return "page";
    }


    @RequestMapping(value = "/products/category/{id}/page/{pageNumber}", method = RequestMethod.GET)
    public String showCategoryProductsPagination(@PathVariable("id") int id, @PathVariable Integer pageNumber, Model model) {

        Category category = categoryService.findCategoryById(id);

        PagedListHolder<Product> page = new PagedListHolder<>(productService.findProductsByCategory(id));
        page.setPageSize(PAGE_SIZE);
        page.setPage(pageNumber - 1);

        int current = page.getPage() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getPageCount());

        String urlPath = "/products/category/" + id + "/page/";

        model.addAttribute("title", category.getName());
        model.addAttribute("categories", categoryService.findAllCategories());

        model.addAttribute("category", category);
        model.addAttribute("products", page.getPageList());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("pageCount", page.getPageCount());

        model.addAttribute("urlPath", urlPath);

        model.addAttribute("userClickCategoryProducts", true);
        return "page";
    }



}
