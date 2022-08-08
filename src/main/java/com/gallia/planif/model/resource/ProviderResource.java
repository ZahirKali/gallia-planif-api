package com.gallia.planif.model.resource;

import lombok.Data;

@Data
public class ProviderResource implements ResourceComponent {
    private long id;
    private String name;
}
