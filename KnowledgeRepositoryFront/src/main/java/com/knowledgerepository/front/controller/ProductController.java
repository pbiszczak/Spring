package com.knowledgerepository.front.controller;

import com.knowledgerepository.back.entity.Category;
import com.knowledgerepository.back.model.PageListHolderBuilder;
import com.knowledgerepository.back.service.CategoryService;
import com.knowledgerepository.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


        PageListHolderBuilder pageListHolder = buildPageListHolderForAllProducts(pageNumber);
        String urlPath = "/products/all/page/";
        String title = "All Products";
        List<Category> categoryList = findAllCategories();

        model.addAttribute("title", title);
        model.addAttribute("categories", categoryList);
        model.addAttribute("urlPath", urlPath);
        model.addAttribute("userClickCategoryProducts", true);

        model.addAttribute("products", pageListHolder.getPageList());
        model.addAttribute("beginIndex", pageListHolder.getSmallestPageIndexDisplayedInPagination());
        model.addAttribute("endIndex", pageListHolder.getBiggestPageIndexDisplayedInPagination());
        model.addAttribute("currentIndex", pageListHolder.getCurrentPageIndex());
        model.addAttribute("pageCount", pageListHolder.getPageCount());


        return "page";
    }


    @RequestMapping(value = "/products/category/{categoryId}/page/{pageNumber}", method = RequestMethod.GET)
    public String showCategoryProductsPagination(@PathVariable("categoryId") int categoryId, @PathVariable Integer pageNumber, Model model) {

        PageListHolderBuilder pageListHolder = buildPageListHolderForCategoryProducts(pageNumber, categoryId);
        Category category = findCategoryById(categoryId);
        String urlPath = "/products/category/" + categoryId + "/page/";
        String title = category.getName();
        List<Category> categoryList = findAllCategories();

        model.addAttribute("category", category);
        model.addAttribute("title", title);
        model.addAttribute("categories", categoryList);
        model.addAttribute("urlPath", urlPath);
        model.addAttribute("userClickAllProducts", true);

        model.addAttribute("products", pageListHolder.getPageList());
        model.addAttribute("beginIndex", pageListHolder.getSmallestPageIndexDisplayedInPagination());
        model.addAttribute("endIndex", pageListHolder.getBiggestPageIndexDisplayedInPagination());
        model.addAttribute("currentIndex", pageListHolder.getCurrentPageIndex());
        model.addAttribute("pageCount", pageListHolder.getPageCount());


        return "page";
    }


    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @RequestMapping("/delete/product/{id}")
    public String deleteCustomer(@PathVariable("id") int id, @RequestParam("urlPath") String urlPath) {

        productService.deleteProductById(id);

        return "redirect:" + urlPath;
    }

    private List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }


    private Category findCategoryById(int categoryId) {
        return categoryService.findCategoryById(categoryId);
    }


    private PageListHolderBuilder buildPageListHolderForCategoryProducts(int pageNumber, int categoryId) {

        return new PageListHolderBuilder
                .Builder(productService.findProductsByCategory(categoryId))
                .withPageSize(PAGE_SIZE)
                .withSetPage(pageNumber)
                .withCalculatePagesIndexesAndPageCount()
                .build();

    }

    private PageListHolderBuilder buildPageListHolderForAllProducts(int pageNumber) {

        return new PageListHolderBuilder
                .Builder(productService.findAllProducts())
                .withPageSize(PAGE_SIZE)
                .withSetPage(pageNumber)
                .withCalculatePagesIndexesAndPageCount()
                .build();

    }





}
