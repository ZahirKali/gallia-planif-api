package com.gallia.planif.dao.model.resource;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MissionResource implements ResourceComponent {
    private long id;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String comment;
    private ClientResource client;
    private SiteResource site;
    private ProviderResource provider;
    private CollaboratorResource collaborator;
    private double totalWorkedHoursNumber;
    private double morningWorkedHoursNumber;
    private double nightWorkedHoursNumber;
    private double holidayWorkedHoursNumber;
    private double nightHolidayWorkedHoursNumber;
    private double sundayWorkedHoursNumber;

}
