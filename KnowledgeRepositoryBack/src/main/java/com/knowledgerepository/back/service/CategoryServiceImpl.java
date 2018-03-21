package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.CategoryDAO;
import com.knowledgerepository.back.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Transactional
    public List<Category> findAllCategories() {
        return categoryDAO.findAllCategories();
    }

    @Transactional
    public Category findCategoryById(int id) {
        return categoryDAO.findCategoryById(id);
    }
}
