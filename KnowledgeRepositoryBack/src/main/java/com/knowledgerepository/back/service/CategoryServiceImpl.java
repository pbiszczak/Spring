package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.CategoryDEO;
import com.knowledgerepository.back.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDEO categoryDEO;

    @Autowired
    public CategoryServiceImpl(CategoryDEO categoryDEO) {
        this.categoryDEO = categoryDEO;
    }

    @Transactional
    public List<Category> getAllCategories() {
        return categoryDEO.getAllCategories();
    }

    @Transactional
    public Category getCategoryById(int id) {
        return categoryDEO.getCategoryById(id);
    }
}
