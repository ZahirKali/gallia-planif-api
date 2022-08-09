package com.gallia.planif.dao.model.request;

import lombok.Data;

@Data
public class SiteRequest implements RequestComponent {
    private String name;
    private AddressRequest address;
}
