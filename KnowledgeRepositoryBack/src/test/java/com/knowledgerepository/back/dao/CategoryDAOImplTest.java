package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CategoryDAOImplTest extends EntityDaoImplTest {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("Category.xml"));

    }

    @Test
    public void getAllCategoriesTest() {
        List<Category> testCategoryList = categoryDAO.getAllCategories();
        Assert.assertEquals(testCategoryList.get(0).getId(), 1, "Id should be \"1\"");
        Assert.assertEquals(testCategoryList.get(0).getName(), "Laptop", "Name should be \"Laptop\"");

    }
    @Test
    public void getCategoryByIdTest() {
        Category testCategory = categoryDAO.getCategoryById(2);
        Assert.assertEquals(testCategory.getId(), 2, "Id should be \"2\"");
        Assert.assertEquals(testCategory.getName(), "Television", "Name should be \"Television\"");

    }




}
