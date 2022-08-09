package com.gallia.planif.dao.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "provider")
public class ProviderEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String name;
}
