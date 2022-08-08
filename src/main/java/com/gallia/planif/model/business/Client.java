package com.gallia.planif.model.business;

import lombok.Data;

@Data
public class Client implements BusinessComponent {
    private long id;
    private String name;
}
