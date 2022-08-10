package com.gallia.planif.dao.model.business;

import lombok.Data;

@Data
public class Address implements BusinessComponent{
    private Long id;
    private String number;
    private String type; // rue, avenue ...
    private String label; // Nilson Mandela ...
    private int postCode;
    private String city;
}
