package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SiteEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private String name;

    @ManyToOne
    private AddressEntity address;
}
