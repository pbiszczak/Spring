package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAllProducts();
    List findProductsByCategory(int categoryId);

}
