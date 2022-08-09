package com.gallia.planif.dao.model.resource;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MissionResource implements ResourceComponent {
    private long id;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String comment;
    private ClientResource client;
    private SiteResource site;
    private ProviderResource provider;
    private CollaboratorResource collaborator;
}
