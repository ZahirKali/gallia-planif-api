package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ProviderEntity implements EntityComponent {
    private long id;
    private String name;
}
