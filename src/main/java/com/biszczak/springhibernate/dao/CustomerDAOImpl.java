package com.biszczak.springhibernate.dao;

import com.biszczak.springhibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// apply repository to DAO implementations
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject the session factory
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // using constructor injection is better than field injections


    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Customer> getCustomersFromDB =
                currentSession.createQuery("from Customer order by lastName", Customer.class);


        // return the results
        return getCustomersFromDB.getResultList();
    }

    public void saveCustomer(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);      // saveOrUpdate - let hibernate choose proper function

    }

    public Customer getCustomer(int id) {

        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, id);

    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query deleteCustomerQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        deleteCustomerQuery.setParameter("customerId", id);

        deleteCustomerQuery.executeUpdate();
    }
}
