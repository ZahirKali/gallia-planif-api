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

    @ManyToOne(cascade = CascadeType.MERGE)
    private ClientEntity client;

    @ManyToOne(cascade = CascadeType.MERGE)
    private SiteEntity site;

    @ManyToOne(cascade = CascadeType.MERGE)
    private ProviderEntity provider;

    @ManyToOne(cascade = CascadeType.MERGE)
    private CollaboratorEntity collaborator;

    @Column
    private double totalWorkedHoursNumber;

    @Column
    private double morningWorkedHoursNumber;

    @Column
    private double nightWorkedHoursNumber;
}
