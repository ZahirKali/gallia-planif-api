package com.gallia.planif.dao.model.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity(name = "collaborator")
public class CollaboratorEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @NaturalId
    @Column
    private String proCardNumber;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private ZonedDateTime birthDay;
}
