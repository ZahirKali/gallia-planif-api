package com.gallia.planif.model.business;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Mission implements BusinessComponent{
    private long id;
    private ZonedDateTime start;
    private ZonedDateTime end;
    private String comment;
    private Client client;
    private Site site;
    private Provider provider;
    private Collaborator collaborator;
}
