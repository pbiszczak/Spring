package com.knowledgerepository.back.service;

import com.knowledgerepository.back.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();
    List findProductsByCategory(int categoryId);
}
