package com.gallia.planif.exception;

public class EntityNotFoundException extends RuntimeException {

    private final String entityName;
    private final Long id;

    public EntityNotFoundException(String entity, Long id) {
        this.entityName = entity;
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public Long getId() {
        return id;
    }
}
