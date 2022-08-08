package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Data
@Entity
public class CollaboratorEntity implements EntityComponent {
    private long id;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;
}
