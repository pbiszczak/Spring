package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Basket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasketDAOImpl implements BasketDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public BasketDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveBasket(Basket Basket) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(Basket);
    }

    @Override
    public Basket findBasketById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Basket.class, id);
    }

    @Override
    public void deleteBasketById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query deleteBasketByIdFromDB = currentSession.createQuery("delete from Basket where id=:BasketId");
        deleteBasketByIdFromDB.setParameter("BasketId", id);

        deleteBasketByIdFromDB.executeUpdate();
    }
}
