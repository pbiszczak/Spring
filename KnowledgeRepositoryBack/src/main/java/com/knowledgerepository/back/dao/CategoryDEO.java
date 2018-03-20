package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;

import java.util.List;

public interface CategoryDEO {

    List<Category> getAllCategories();
    Category getCategoryById(int id);
}
