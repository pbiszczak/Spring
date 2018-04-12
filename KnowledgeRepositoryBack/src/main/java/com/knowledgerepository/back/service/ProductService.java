package com.knowledgerepository.back.service;

import com.knowledgerepository.back.entity.Product;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    List<Product> findProductsByCategory(int categoryId);

    @Secured("ROLE_ADMIN")
    void saveProduct(Product product);

    Product findProductById(int id);

    @Secured("ROLE_ADMIN")
    void deleteProductById(int id);

}
