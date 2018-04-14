package com.knowledgerepository.back.service;


import com.knowledgerepository.back.dao.CategoryDAO;
import com.knowledgerepository.back.entity.Category;
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

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;


public class CategoryServiceImplTest {

    @Mock
    CategoryDAO categoryDAO;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Spy
    List<Category> categories = new ArrayList<Category>();

    @BeforeMethod
    public void buildSpy() {
        setupCategories();
    }

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindCategoryById() {
        Category category = categories.get(1);
        when(categoryDAO.findCategoryById(anyInt())).thenReturn(category);
        Assert.assertEquals(categoryService.findCategoryById(category.getId()), category);
    }

    @Test
    public void testFindAllCategories() {
        categories = categoryService.findAllCategories();
        when(categoryDAO.findAllCategories()).thenReturn(categories);
        Assert.assertEquals(categoryService.findAllCategories(), categories);
    }


    public void setupCategories() {
        this.categories = new ArrayList<>();
        Category category1 = new Category();
        category1.setName("Laptop");
        category1.setId(1);
        category1.setDescription("Laptop description");

        Category category2 = new Category();
        category2.setName("Television");
        category2.setId(2);
        category2.setDescription("Television description");

        this.categories.add(category1);
        this.categories.add(category2);
    }
}