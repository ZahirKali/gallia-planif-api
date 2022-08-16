package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.BusinessComponent;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.RequestComponent;
import com.gallia.planif.dao.model.resource.ResourceComponent;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractController<
        T extends BusinessComponent,
        E extends RequestComponent,
        R extends ResourceComponent> {

    private AbstractGenericService service;
    private BusinessRequestMapper requestMapper;
    private BusinessResourceMapper resourceMapper;

    protected AbstractController(BusinessRequestMapper requestMapper,
                                 BusinessResourceMapper resourceMapper,
                                 AbstractGenericService service) {
        this.requestMapper = requestMapper;
        this.resourceMapper = resourceMapper;
        this.service = service;
    }


    public ResponseEntity<R> create(E request) {
        T component = (T) requestMapper.map(request);
        T created = (T) service.create(component);
        return ResponseEntity.ok((R) resourceMapper.map(created));
    }


    public ResponseEntity<Collection<R>> getAll() {
        Collection<T> all = service.getAll();
        List<R> resources = all.stream()
                .map(resourceMapper::map)
                .map(it -> (R) it)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }


    public ResponseEntity<R> update(E request, Long id) {
        T component = (T) requestMapper.map(request);
        T updated = (T) service.update(component);
        return ResponseEntity.ok((R) resourceMapper.map(updated));
    }


    public void delete(Long id) {
        service.delete(id);
    }
}
