package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Address;

public interface AddressDAO {
    Address findAddressById(int id);
}
