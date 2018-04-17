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
    public User findUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> findUserByUsernameFromDB = currentSession.createQuery("from User where email=:userEmail", User.class);
        findUserByUsernameFromDB.setParameter("userEmail", email);
        return findUserByUsernameFromDB.getSingleResult();
    }

    @Override
    public User findUserByEmailAndFetchAddresses(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> findUserByUsernameFromDB = currentSession.createQuery("SELECT u from User u JOIN FETCH u.addresses where u.email=:userEmail", User.class);
        findUserByUsernameFromDB.setParameter("userEmail", email);
        return findUserByUsernameFromDB.getSingleResult();
    }
}
