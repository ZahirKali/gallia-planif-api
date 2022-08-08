package com.gallia.planif.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.ZonedDateTime;

@Data
@Entity
public class CollaboratorEntity implements EntityComponent {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private ZonedDateTime birthDay;
}
