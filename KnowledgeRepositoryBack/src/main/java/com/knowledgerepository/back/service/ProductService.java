package com.knowledgerepository.back.service;

import com.knowledgerepository.back.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    List<Product> findProductsByCategory(int categoryId);

    void saveProduct(Product product);

    Product findProductById(int id);

    void deleteProductById(int id);

}
