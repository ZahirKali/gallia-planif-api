package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private String number;

    @Column
    private String type; // rue, avenue ...

    @Column
    private String label; // Nilson Mandela ...

    @Column
    private int postCode;

    @Column
    private String city;
}
