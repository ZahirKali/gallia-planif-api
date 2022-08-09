package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
public class MissionEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private ZonedDateTime start;

    @Column
    private ZonedDateTime end;

    @Column
    private String comment;

    @ManyToOne
    private ClientEntity client;

    @ManyToOne
    private SiteEntity site;

    @ManyToOne
    private ProviderEntity provider;

    @ManyToOne
    private CollaboratorEntity collaborator;
}
