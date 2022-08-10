package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Collaborator;
import com.gallia.planif.dao.model.entity.CollaboratorEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.CollaboratorRepository;
import com.gallia.planif.exception.EntityNotFoundException;
import com.gallia.planif.service.CollaboratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {
    private final Logger LOGGER = LoggerFactory.getLogger(CollaboratorServiceImpl.class);

    private final BusinessEntityMapper mapper;

    private final CollaboratorRepository repository;

    public CollaboratorServiceImpl(BusinessEntityMapper mapper, CollaboratorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Collaborator create(Collaborator collaborator) {
        LOGGER.info("Create collaborator '{}'", collaborator.toString());
        CollaboratorEntity entity = mapper.map(collaborator);
        CollaboratorEntity saved = repository.save(entity);
        return mapper.map(saved);
    }

    @Override
    public Collection<Collaborator> getAll() {
        LOGGER.info("Get all collaborators");
        return repository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Collaborator update(Collaborator collaborator) {
        LOGGER.info("Update collaborator '{}'", collaborator.getId());
        Optional<CollaboratorEntity> found = repository.findById(collaborator.getId());
        if (found.isEmpty()) {
            throw new EntityNotFoundException("collaborator", collaborator.getId());
        }
        CollaboratorEntity updated = repository.save(mapper.map(collaborator));
        return mapper.map(updated);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Delete collaborator '{}'", id);
        Optional<CollaboratorEntity> entity = repository.findById(id);
        if(entity.isEmpty()) {
            throw new EntityNotFoundException("collaborator", id);
        }
        repository.delete(entity.get());
    }
}
