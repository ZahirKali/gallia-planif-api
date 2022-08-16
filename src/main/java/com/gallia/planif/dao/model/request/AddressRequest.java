package com.gallia.planif.dao.model.request;

import lombok.Data;

@Data
public class AddressRequest implements RequestComponent {
    private Long id;
    private String number;
    private String type; // rue, avenue ...
    private String label; // Nilson Mandela ...
    private int postCode;
    private String city;
}
