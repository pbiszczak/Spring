package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getAllCategories();
    Category getCategoryById(int id);
}
