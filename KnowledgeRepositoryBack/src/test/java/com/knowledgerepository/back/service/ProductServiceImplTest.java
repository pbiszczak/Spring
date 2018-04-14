package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.ProductDAO;
import com.knowledgerepository.back.entity.Product;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {


    @Mock
    ProductDAO productDAO;

    @InjectMocks
    ProductServiceImpl productService;

    @Spy
    List<Product> products = new ArrayList<>();

    @Spy
    List<Product> productsFromOneCategory = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void buildSpy() {
        setupProducts();
        setupProductsFromOneCategory();
    }


    @Test
    public void testFindAllProducts() {
        when(productDAO.findAllProducts()).thenReturn(products);
        Assert.assertEquals(productService.findAllProducts(), products);
        Assert.assertEquals(productService.findAllProducts().size(), 3);
    }

    @Test
    public void testFindProductsByCategory() {
        int categoryId = 1;
        when(productDAO.findProductsByCategory(anyInt())).thenReturn(productsFromOneCategory);
        Assert.assertEquals(productService.findProductsByCategory(categoryId), productsFromOneCategory);
        Assert.assertEquals(productService.findProductsByCategory(categoryId).size(), 2);
    }

    @Test
    public void testSaveProduct() {
        doNothing().when(productDAO).saveProduct(any(Product.class));
        productService.saveProduct(any(Product.class));
        verify(productDAO, atLeastOnce()).saveProduct(any(Product.class));
    }

    @Test
    public void testFindProductById() {
        Product product = products.get(1);
        when(productDAO.findProductById(anyInt())).thenReturn(product);
        Assert.assertEquals(productService.findProductById(product.getId()), product);
    }

    @Test
    public void testDeleteProductById() {

        doNothing().when(productDAO).deleteProductById(anyInt());
        productService.deleteProductById(anyInt());
        verify(productDAO, atLeastOnce()).deleteProductById(anyInt());

    }


    public void setupProducts() {
        this.products = new ArrayList<>();
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
    }

    private void setupProductsFromOneCategory() {
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

        this.productsFromOneCategory.add(product1);
        this.productsFromOneCategory.add(product2);
    }

}