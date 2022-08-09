package com.gallia.planif.dao.model.business;

import lombok.Data;

@Data
public class Site implements BusinessComponent {
    private long id;
    private String name;
    private Address address;
}
