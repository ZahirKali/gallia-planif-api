package com.gallia.planif.dao.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity(name = "mission")
public class MissionEntity implements EntityComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private ZonedDateTime startDate;

    @Column
    private ZonedDateTime endDate;

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
