package com.knowledgerepository.back.service;

import com.knowledgerepository.back.dao.AddressDAO;
import com.knowledgerepository.back.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Transactional
    public Address findAddressById(int id) {
        return addressDAO.findAddressById(id);
    }
}
