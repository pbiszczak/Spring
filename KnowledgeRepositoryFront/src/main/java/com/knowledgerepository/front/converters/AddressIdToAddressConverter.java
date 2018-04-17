package com.knowledgerepository.front.converters;


import com.knowledgerepository.back.entity.Address;
import com.knowledgerepository.back.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressIdToAddressConverter implements Converter<String, Address> {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }


    @Override
    public Address convert(String id) {
        try {
            int tradeId = Integer.valueOf(id);
            return addressService.findAddressById(tradeId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
