package com.knowledgerepository.back.service;

import com.knowledgerepository.back.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    Category getCategoryById(int id);
}
