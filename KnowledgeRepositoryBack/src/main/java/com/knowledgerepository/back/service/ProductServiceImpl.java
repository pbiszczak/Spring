package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.ProductDAO;
import com.knowledgerepository.back.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public List<Product> findAllProducts() {
        return productDAO.findAllProducts();
    }

    @Transactional
    public List findProductsByCategory(int categoryId) {
        return productDAO.findProductsByCategory(categoryId);
    }
}
