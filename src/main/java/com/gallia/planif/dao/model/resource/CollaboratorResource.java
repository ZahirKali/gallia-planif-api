package com.gallia.planif.dao.model.resource;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CollaboratorResource implements ResourceComponent {
    private long id;
    private String proCardNumber;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;
}
