package com.knowledgerepository.back.model;


import com.knowledgerepository.back.entity.Address;

import java.util.List;

public final class UserModel {


    private String firstName;

    private String lastName;

    private String email;

    private String contactNumber;

    private List<Address> addresses;

    public UserModel(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.addresses = builder.addresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public static class Builder {


        private String firstName;

        private String lastName;

        private String email;

        private String contactNumber;

        private List<Address> addresses;

        public Builder() {

        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder withAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }

    }
}
