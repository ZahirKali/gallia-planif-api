package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Collaborator;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.CollaboratorRequest;
import com.gallia.planif.dao.model.resource.CollaboratorResource;
import com.gallia.planif.service.CollaboratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

    private final BusinessRequestMapper requestMapper;
    private final BusinessResourceMapper resourceMapper;

    private final CollaboratorService collaboratorService;

    public CollaboratorController(BusinessRequestMapper mapper,
                                  BusinessResourceMapper resourceMapper,
                                  CollaboratorService collaboratorService) {
        this.requestMapper = mapper;
        this.resourceMapper = resourceMapper;
        this.collaboratorService = collaboratorService;
    }

    @PostMapping
    public ResponseEntity<CollaboratorResource> create(@RequestBody CollaboratorRequest request) {
        Collaborator collaborator = requestMapper.map(request);
        Collaborator created = collaboratorService.create(collaborator);
        return ResponseEntity.ok(resourceMapper.map(created));
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<CollaboratorResource>> getAll() {
        Collection<Collaborator> all = collaboratorService.getAll();
        List<CollaboratorResource> resources = all.stream()
                .map(resourceMapper::map)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }
}
