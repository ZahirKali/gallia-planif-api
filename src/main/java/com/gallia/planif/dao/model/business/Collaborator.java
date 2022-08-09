package com.gallia.planif.dao.model.business;

import java.time.ZonedDateTime;

public class Collaborator implements BusinessComponent{
    private long id;
    private String proCardNumber;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProCardNumber() {
        return proCardNumber;
    }

    public void setProCardNumber(String proCardNumber) {
        this.proCardNumber = proCardNumber;
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

    public ZonedDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(ZonedDateTime birthDay) {
        this.birthDay = birthDay;
    }
}
