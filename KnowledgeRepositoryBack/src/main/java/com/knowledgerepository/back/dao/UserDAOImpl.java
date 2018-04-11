package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> findUserByUsernameFromDB = currentSession.createQuery("from User where email=:userEmail", User.class);
        findUserByUsernameFromDB.setParameter("userEmail", username);
        return findUserByUsernameFromDB.getSingleResult();
    }
}
