package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CategoryDAOImplTest extends EntityDaoImplTest {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("Category.xml"));

    }


    @Test
    public void findAllCategoriesTest() {

        Assert.assertEquals(categoryDAO.findAllCategories().get(0).getId(), 1);
        Assert.assertEquals(categoryDAO.findAllCategories().get(0).getName(), "Laptop");
        Assert.assertEquals(categoryDAO.findAllCategories().size(), 3);

    }
    @Test
    public void findCategoryByIdTest() {

        Assert.assertEquals(categoryDAO.findCategoryById(2).getId(), 2);
        Assert.assertEquals(categoryDAO.findCategoryById(2).getName(), "Television");
        Assert.assertEquals(categoryDAO.findCategoryById(2).isActive(), true);

    }

    @Test
    public void addCategoryTest() {
        Category category = getSampleCategory();
        categoryDAO.addCategory(category);

        Assert.assertEquals(categoryDAO.findAllCategories().size(), 4);
        Assert.assertEquals(category.getId(), categoryDAO.findCategoryById(4).getId());
        Assert.assertEquals(categoryDAO.findCategoryById(4).getName(), "Smartwatch");


    }

    @Test
    public void deleteCategory() {
        Category category = categoryDAO.findCategoryById(1);
        categoryDAO.deleteCategory(category);

        Assert.assertEquals(categoryDAO.findAllCategories().size(), 2, "Size should be 2.");
        Assert.assertEquals(categoryDAO.findAllCategories().get(0).getName(), "Television", "First list element should be \"Television\"");
        Assert.assertNull(categoryDAO.findCategoryById(1), "Category with ID - 1, shouldn't exist");
    }


    private Category getSampleCategory(){
        Category category = new Category();
        category.setName("Smartwatch");
        category.setDescription("Smartwatch description");
        category.setImageUrl("smartwatch.png");
        category.setActive(false);

        return category;
    }




    }
