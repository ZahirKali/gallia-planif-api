package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Collaborator;
import com.gallia.planif.dao.model.entity.CollaboratorEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl extends AbstractGenericService<Collaborator, CollaboratorEntity> {

    public CollaboratorServiceImpl(GenericRepository<CollaboratorEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }
}
