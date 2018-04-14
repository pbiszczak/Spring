package com.knowledgerepository.front.controller;

import com.knowledgerepository.back.entity.Category;
import com.knowledgerepository.back.entity.Product;
import com.knowledgerepository.back.service.CategoryService;
import com.knowledgerepository.back.service.ProductService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    @Mock
    ProductService productService;
    @Mock
    CategoryService categoryService;
    @InjectMocks
    ProductController productController;
    @Spy
    List<Category> categories = new ArrayList<>();
    @Spy
    Category category;
    private MockMvc mockMvc;
    @Spy
    private List<Product> products = new ArrayList<>();
    @Spy
    private List<Product> productsFromOneCategory = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @BeforeMethod
    public void buildSpy() {
        setupSpies();
    }


    @Test
    public void testShowAllProductsPagination() throws Exception {

        when(productService.findAllProducts()).thenReturn(products);
        when(categoryService.findAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/products/all/page/{pageNumber}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("page"))
                .andExpect(model().attribute("products", Arrays.asList(products.get(0), products.get(1))))
                .andExpect(model().attribute("pageCount", 2))
                .andExpect(model().attribute("categories", categories));


    }

    @Test
    public void testShowCategoryProductsPagination() throws Exception {

        when(productService.findProductsByCategory(anyInt())).thenReturn(productsFromOneCategory);
        when(categoryService.findAllCategories()).thenReturn(categories);
        when(categoryService.findCategoryById(anyInt())).thenReturn(category);

        mockMvc.perform(get("/products/category/{categoryId}/page/{pageNumber}", 1, 1))
                .andExpect(status().isOk())
                .andExpect(view().name("page"))
                .andExpect(model().attribute("products", productsFromOneCategory))
                .andExpect(model().attribute("pageCount", 1))
                .andExpect(model().attribute("category", category))
                .andExpect(model().attribute("categories", categories));

    }

    @Test
    public void testDeleteCustomer() throws Exception {

        doNothing().when(productService).deleteProductById(anyInt());
        productService.deleteProductById(anyInt());
        verify(productService, atLeastOnce()).deleteProductById(anyInt());

        String urlPathParam = "/products/all/page/1";
        String expectedRedirectUrl = "/products/all/page/1";
        String expectedName = "redirect:/products/all/page/1";

        mockMvc.perform(get("/delete/product/{id}", 1)
                .param("urlPath", urlPathParam))
                .andExpect(redirectedUrl(expectedRedirectUrl))
                .andExpect(view().name(expectedName));


    }

    private void setupSpies() {

        setupProductsSpies();
        setupCategoriesSpies();

    }

    private void setupProductsSpies() {
        this.products = new ArrayList<>();
        this.productsFromOneCategory = new ArrayList<>();


        Product product1 = new Product();
        product1.setId(1);
        product1.setName("iPhone 5s");
        product1.setCode("PHONEx1");
        product1.setBrand("apple");
        product1.setCategory(1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Samsung s7");
        product2.setCode("PHONEx2");
        product2.setBrand("samsung");
        product2.setCategory(1);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Dell");
        product3.setCode("LAPTOPx1");
        product3.setBrand("dell");
        product3.setCategory(3);


        this.products.add(product1);
        this.products.add(product2);
        this.products.add(product3);

        this.productsFromOneCategory.add(product1);
        this.productsFromOneCategory.add(product2);
    }

    public void setupCategoriesSpies() {
        this.categories = new ArrayList<>();
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("Laptop");
        category1.setDescription("Laptop description");

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Television");
        category2.setDescription("Television description");

        this.category = category1;

        this.categories.add(category1);
        this.categories.add(category2);
    }

}