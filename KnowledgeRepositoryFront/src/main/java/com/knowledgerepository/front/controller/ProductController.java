package com.knowledgerepository.front.controller;

import com.knowledgerepository.back.entity.Category;
import com.knowledgerepository.back.entity.Product;
import com.knowledgerepository.back.service.CategoryService;
import com.knowledgerepository.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final int PAGE_SIZE = 2;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @RequestMapping(value = "/products/all/page/{pageNumber}", method = RequestMethod.GET)
    public String showAllProductsPagination(@PathVariable int pageNumber, Model model) {


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

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @RequestMapping("/delete/product/{id}")
    public String deleteCustomer(@PathVariable("id") int id, @RequestParam("urlPath") String urlPath) {

        productService.deleteProductById(id);

        return "redirect:" + urlPath;
    }


}
