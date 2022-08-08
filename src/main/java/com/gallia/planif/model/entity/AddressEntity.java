package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class AddressEntity implements EntityComponent {
    private long id;
    private String number;
    private String type; // rue, avenue ...
    private String label; // Nilson Mandela ...
    private int postCode;
    private String city;
}
