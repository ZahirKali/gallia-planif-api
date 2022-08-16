package com.gallia.planif.dao.model.request;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MissionRequest implements RequestComponent {
    private Long id;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String comment;
    private ClientRequest client;
    private SiteRequest site;
    private ProviderRequest provider;
    private CollaboratorRequest collaborator;
}
