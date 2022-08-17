package com.gallia.planif.dao.model.business;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Mission implements BusinessComponent{
    private Long id;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String comment;
    private Client client;
    private Site site;
    private Provider provider;
    private Collaborator collaborator;
    private double totalWorkedHoursNumber;
    private double morningWorkedHoursNumber;
    private double nightWorkedHoursNumber;
    private double holidayWorkedHoursNumber;
    private double nightHolidayWorkedHoursNumber;
    private double sundayWorkedHoursNumber;
}
