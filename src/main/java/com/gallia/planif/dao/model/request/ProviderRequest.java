package com.gallia.planif.dao.model.request;

import lombok.Data;

@Data
public class ProviderRequest implements RequestComponent {
    private Long id;
    private String name;
}
