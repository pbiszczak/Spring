package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> findAllCategories();
    Category findCategoryById(int id);
    void addCategory(Category category);
    void deleteCategory(Category category);
}
