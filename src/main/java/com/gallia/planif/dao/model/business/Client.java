package com.gallia.planif.dao.model.business;

import lombok.Data;

@Data
public class Client implements BusinessComponent {
    private long id;
    private String name;
}
