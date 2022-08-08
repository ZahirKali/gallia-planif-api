package com.gallia.planif.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class AddressEntity implements EntityComponent {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String number;
    private String type; // rue, avenue ...
    private String label; // Nilson Mandela ...
    private int postCode;
    private String city;
}
