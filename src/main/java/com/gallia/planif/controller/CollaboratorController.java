package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Collaborator;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.CollaboratorRequest;
import com.gallia.planif.dao.model.resource.CollaboratorResource;
import com.gallia.planif.service.impl.CollaboratorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CollaboratorController extends AbstractController<Collaborator, CollaboratorRequest, CollaboratorResource> {

    private final String END_POINT = "/collaborator";

    public CollaboratorController(BusinessRequestMapper requestMapper, BusinessResourceMapper resourceMapper, CollaboratorServiceImpl service) {
        super(requestMapper, resourceMapper, service);
    }

    @PostMapping(END_POINT)
    @Override
    public ResponseEntity<CollaboratorResource> create(@RequestBody CollaboratorRequest request) {
        return super.create(request);
    }

    @GetMapping(END_POINT)
    @Override
    public ResponseEntity<Collection<CollaboratorResource>> getAll() {
        return super.getAll();
    }

    @PostMapping(END_POINT + "/id/{id}/update")
    @Override
    public ResponseEntity<CollaboratorResource> update(@RequestBody CollaboratorRequest request, @PathVariable Long id) {
        return super.update(request, id);
    }

    @DeleteMapping(END_POINT + "/id/{id}/delete")
    @Override
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
