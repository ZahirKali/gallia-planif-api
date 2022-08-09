package com.gallia.planif.dao.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "site")
public class SiteEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private AddressEntity address;
}
