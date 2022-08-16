package com.gallia.planif.dao.model.request;

import lombok.Data;

@Data
public class ClientRequest implements RequestComponent {
    private Long id;
    private String name;
}
