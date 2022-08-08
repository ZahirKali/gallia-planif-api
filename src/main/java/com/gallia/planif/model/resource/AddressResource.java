package com.gallia.planif.model.resource;

import lombok.Data;

@Data
public class AddressResource implements ResourceComponent {
    private long id;
    private String number;
    private String type; // rue, avenue ...
    private String label; // Nilson Mandela ...
    private int postCode;
    private String city;
}
