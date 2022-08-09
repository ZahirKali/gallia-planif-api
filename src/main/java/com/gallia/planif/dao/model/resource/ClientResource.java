package com.gallia.planif.dao.model.resource;

import lombok.Data;

@Data
public class ClientResource implements ResourceComponent {
    private long id;
    private String name;
}
