package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO {

    private final SessionFactory sessionFactory;


    @Autowired
    public AddressDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Address findAddressById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Address.class, id);
    }
}
