package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.User;

public interface UserDAO {
    User findUserByUsername(String username);
}
