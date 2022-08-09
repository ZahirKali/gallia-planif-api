package com.gallia.planif.dao.model.request;

import java.time.ZonedDateTime;


public class CollaboratorRequest implements RequestComponent {
    private String proCardNumber;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;

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
