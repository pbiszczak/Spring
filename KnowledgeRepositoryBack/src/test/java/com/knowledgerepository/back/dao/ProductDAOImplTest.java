package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Product;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDAOImplTest extends EntityDaoImplTest {

    @Autowired
    ProductDAO productDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("Product.xml"));

    }

    @Test
    public void testFindAllProducts() {
        Assert.assertEquals(productDAO.findAllProducts().size(), 3);
        Assert.assertEquals(productDAO.findAllProducts().get(0).getId(), 1);
    }

    @Test
    public void testFindProductsByCategory() {
        Assert.assertEquals(productDAO.findProductsByCategory(1).size(), 2);
        Assert.assertEquals(productDAO.findProductsByCategory(3).size(), 1);
        Assert.assertTrue(productDAO.findProductsByCategory(2).isEmpty());
    }

    @Test
    public void testSaveProduct() {
        Product saveProduct = getSampleProduct();
        productDAO.saveProduct(saveProduct);

        Assert.assertEquals(productDAO.findAllProducts().size(), 4);
        Assert.assertEquals(productDAO.findProductById(saveProduct.getId()).getId(), saveProduct.getId());
        Assert.assertNotNull(productDAO.findProductById(4));
    }

    @Test
    public void testFindProductById() {
        Assert.assertNotNull(productDAO.findProductById(1));
        Assert.assertNull(productDAO.findProductById(4));
    }

    @Test
    public void testDeleteProductById() {
        productDAO.deleteProductById(1);

        Assert.assertEquals(productDAO.findAllProducts().size(), 2);
        Assert.assertNull(productDAO.findProductById(1));

    }

    private Product getSampleProduct() {
        Product product = new Product();
        product.setCode("PHONEx3");
        product.setName("Google Pixel");
        product.setBrand("google");
        product.setDescription("google description");
        product.setPrice(1200);
        product.setActive(true);

        return product;
    }
}