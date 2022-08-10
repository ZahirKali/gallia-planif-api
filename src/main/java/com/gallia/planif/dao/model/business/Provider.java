package com.gallia.planif.dao.model.business;

import lombok.Data;

@Data
public class Provider implements BusinessComponent{
    private Long id;
    private String name;
}
