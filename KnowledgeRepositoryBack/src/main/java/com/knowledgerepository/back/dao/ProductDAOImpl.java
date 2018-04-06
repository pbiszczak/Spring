package com.knowledgerepository.back.dao;


import com.knowledgerepository.back.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Product> findAllProducts() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Product> getAllProductsFromDB = currentSession.createQuery("from Product", Product.class);

        return getAllProductsFromDB.getResultList();
    }

    @Override
    public List<Product> findProductsByCategory(int categoryId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Product> findProductsByCategoryInDB = currentSession.createQuery("from Product where category=:categoryId", Product.class);
        findProductsByCategoryInDB.setParameter("categoryId", categoryId);

        return findProductsByCategoryInDB.getResultList();

    }
}
