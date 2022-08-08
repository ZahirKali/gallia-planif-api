package com.gallia.planif.model.resource;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CollaboratorResource implements ResourceComponent {
    private long id;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;
}
