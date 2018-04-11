package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.UserDAO;
import com.knowledgerepository.back.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public CustomUserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByUsername(username);
        UserBuilder userBuilder = null;


        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.disabled(!user.isEnabled());
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRole());

        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return userBuilder.build();
    }

}
