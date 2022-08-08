package com.gallia.planif.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class ProviderEntity implements EntityComponent {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
