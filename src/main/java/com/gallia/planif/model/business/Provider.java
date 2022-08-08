package com.gallia.planif.model.business;

import lombok.Data;

@Data
public class Provider implements BusinessComponent{
    private long id;
    private String name;
}
