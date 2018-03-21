package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {



    private final SessionFactory sessionFactory;


    @Autowired
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Category> findAllCategories() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Category> getAllCategoriesFromDB = currentSession.createQuery("from Category", Category.class);

        return getAllCategoriesFromDB.getResultList();
    }

    @Override
    public Category findCategoryById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Category.class, id);
    }

    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public void deleteCategory(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }





}
