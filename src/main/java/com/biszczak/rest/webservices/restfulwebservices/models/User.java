package com.biszczak.rest.webservices.restfulwebservices.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 35, message = "Name should have atleast 3 character, and 35 at max")
    private String name;

    @NotNull
    @Past
    private Date brithDate;


    protected User() {
    }

    public User(Integer id, String name, Date brithDate) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }
}
