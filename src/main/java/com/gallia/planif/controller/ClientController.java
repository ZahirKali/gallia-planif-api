package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Client;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.ClientRequest;
import com.gallia.planif.dao.model.resource.ClientResource;
import com.gallia.planif.service.impl.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClientController extends AbstractController<Client, ClientRequest, ClientResource> {

    private final String END_POINT = "/client";

    public ClientController(BusinessRequestMapper requestMapper, BusinessResourceMapper resourceMapper, ClientServiceImpl service) {
        super(requestMapper, resourceMapper, service);
    }

    @PostMapping(END_POINT)
    @Override
    public ResponseEntity<ClientResource> create(@RequestBody ClientRequest request) {
        return super.create(request);
    }

    @GetMapping(END_POINT)
    @Override
    public ResponseEntity<Collection<ClientResource>> getAll() {
        return super.getAll();
    }

    @PostMapping(END_POINT + "/id/{id}/update")
    @Override
    public ResponseEntity<ClientResource> update(@RequestBody ClientRequest request, @PathVariable Long id) {
        return super.update(request, id);
    }

    @DeleteMapping(END_POINT + "/id/{id}/delete")
    @Override
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
