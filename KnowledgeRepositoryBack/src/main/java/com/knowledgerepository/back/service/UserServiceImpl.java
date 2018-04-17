package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.UserDAO;
import com.knowledgerepository.back.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Transactional
    public User findUserByEmailAndFetchAddresses(String email) {
        return userDAO.findUserByEmailAndFetchAddresses(email);
    }
}
