package com.gallia.planif.model.business;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Collaborator implements BusinessComponent{
    private long id;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;
}
