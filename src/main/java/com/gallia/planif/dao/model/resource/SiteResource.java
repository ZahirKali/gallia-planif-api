package com.gallia.planif.dao.model.resource;

import lombok.Data;

@Data
public class SiteResource implements ResourceComponent {
    private long id;
    private String name;
    private AddressResource address;
}
