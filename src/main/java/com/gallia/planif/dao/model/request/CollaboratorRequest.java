package com.gallia.planif.dao.model.request;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CollaboratorRequest implements RequestComponent {
    private Long id;
    private String proCardNumber;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;
}
