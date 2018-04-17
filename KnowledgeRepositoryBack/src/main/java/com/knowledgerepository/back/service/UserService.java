package com.knowledgerepository.back.service;

import com.knowledgerepository.back.entity.User;

public interface UserService {

    User findUserByEmail(String email);

    User findUserByEmailAndFetchAddresses(String email);


}
