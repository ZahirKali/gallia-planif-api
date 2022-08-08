package com.gallia.planif.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Data
@Entity
public class MissionEntity implements EntityComponent {
    private long id;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String comment;
    private ClientEntity client;
    private SiteEntity site;
    private ProviderEntity provider;
    private CollaboratorEntity collaborator;
}
