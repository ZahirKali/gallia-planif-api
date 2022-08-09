package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
public class CollaboratorEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private ZonedDateTime birthDay;
}
