package com.gallia.planif.dao.model.business;

import lombok.Data;

@Data
public class Provider implements BusinessComponent{
    private long id;
    private String name;
}
