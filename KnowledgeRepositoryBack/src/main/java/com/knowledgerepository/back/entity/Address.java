package com.knowledgerepository.back.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address_line_one")
    @NotBlank(message = "Address Line One is required!")
    private String addressLineOne;

    @Column(name = "address_line_two")
    @NotBlank(message = "Address Line Two is required!")
    private String addressLineTwo;

    @Column(name = "city")
    @NotBlank(message = "City is required!")
    private String city;

    @Column(name = "state")
    @NotBlank(message = "State is required!")
    private String state;

    @Column(name = "country")
    @NotBlank(message = "Country is required!")
    private String country;

    @Column(name = "postal_code")
    @NotBlank(message = "Postal Code is required!")
    private String postal_code;

    @Column(name = "billing")
    private boolean billing;

    @Column(name = "shipping")
    private boolean shipping;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    @Override
    public String toString() {
        return
                addressLineOne
                        + ' ' + addressLineTwo
                        + ", " + city
                        + ' ' + postal_code
                        + ' ' + city
                ;
    }
}
