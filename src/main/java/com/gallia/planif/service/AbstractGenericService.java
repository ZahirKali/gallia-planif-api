package com.gallia.planif.service;

import com.gallia.planif.dao.model.business.BusinessComponent;
import com.gallia.planif.dao.model.entity.CollaboratorEntity;
import com.gallia.planif.dao.model.entity.EntityComponent;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.StreamSupport;

public abstract class AbstractGenericService<T extends BusinessComponent, E extends EntityComponent> {
    private final Logger LOGGER = LoggerFactory.getLogger(AbstractGenericService.class);

    protected GenericRepository<E, Long> repository;
    protected BusinessEntityMapper mapper;

    public AbstractGenericService(GenericRepository<E, Long> repository, BusinessEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public T create(T t) {
        LOGGER.info("Create component '{}'", t.getClass().getSimpleName());
        E entity = (E) mapper.map(t);
        E saved = repository.save(entity);
        return (T) mapper.map(saved);
    }

    public Collection<T> getAll() {
        LOGGER.debug("Get all components");
        Iterable<E> all = repository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .map(mapper::map)
                .map(it -> (T) it)
                .toList();
    }

    public T update(T t) {
        LOGGER.info("Update t '{}' with id '{}'", t.getClass().getSimpleName(), t.getId());
        Optional<E> found = repository.findById(t.getId());
        if (found.isEmpty()) {
            throw new EntityNotFoundException(t.getClass().getSimpleName(), t.getId());
        }
        E entity = (E) mapper.map(t);
        E updated = (E) repository.save(entity);
        return (T) mapper.map(updated);
    }

    public void delete(Long id) {
        LOGGER.info("Delete component with id '{}'", id);
        Optional<E> entity = repository.findById(id);
        if(entity.isEmpty()) {
            throw new EntityNotFoundException("component", id);
        }
        repository.delete(entity.get());
    }
}
