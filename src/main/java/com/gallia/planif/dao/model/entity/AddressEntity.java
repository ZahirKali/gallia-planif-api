package com.gallia.planif.dao.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "address")
public class AddressEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

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
