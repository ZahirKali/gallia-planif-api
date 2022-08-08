package com.gallia.planif.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.ZonedDateTime;

@Data
@Entity
public class MissionEntity implements EntityComponent {
    @Id
    @GeneratedValue
    private int id;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String comment;
    private ClientEntity client;
    private SiteEntity site;
    private ProviderEntity provider;
    private CollaboratorEntity collaborator;
}
