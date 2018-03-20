package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDEOImpl implements CategoryDEO {



    private final SessionFactory sessionFactory;

//    private static List<Category> categories = new ArrayList<>();
//    static {
//        Category category = new Category();
//
//        category.setId(1);
//        category.setName("Television");
//        category.setDescription("This is some description for TV!");
//        category.setImageUrl("CAT_1.png");
//
//        categories.add(category);
//
//        category = new Category();
//        category.setId(2);
//        category.setName("Mobile");
//        category.setDescription("This is some description for mobiles!");
//        category.setImageUrl("CAT_2.png");
//
//        categories.add(category);
//
//        category = new Category();
//        category.setId(3);
//        category.setName("Laptop");
//        category.setDescription("This is some description for laptops!");
//        category.setImageUrl("CAT_3.png");
//
//        categories.add(category);
//    }

    @Autowired
    public CategoryDEOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Category> getAllCategories() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Category> getAllCategoriesFromDB = currentSession.createQuery("from Category", Category.class);

        return getAllCategoriesFromDB.getResultList();
    }

    @Override
    public Category getCategoryById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Category.class, id);
    }
}
