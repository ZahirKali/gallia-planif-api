package com.gallia.planif.dao.model.request;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MissionRequest implements RequestComponent {
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String comment;
    private ClientRequest client;
    private SiteRequest site;
    private ProviderRequest provider;
    private CollaboratorRequest collaborator;
}
