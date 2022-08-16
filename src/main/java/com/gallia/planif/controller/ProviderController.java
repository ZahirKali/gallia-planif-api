package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Provider;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.ProviderRequest;
import com.gallia.planif.dao.model.resource.ProviderResource;
import com.gallia.planif.service.impl.ProviderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProviderController extends AbstractController<Provider,
        ProviderRequest, ProviderResource> {

    private final String END_POINT = "/provider";

    public ProviderController(BusinessRequestMapper requestMapper,
                              BusinessResourceMapper resourceMapper,
                              ProviderServiceImpl service) {
        super(requestMapper, resourceMapper, service);
    }

    @PostMapping(END_POINT)
    @Override
    public ResponseEntity<ProviderResource> create(@RequestBody ProviderRequest request) {
        return super.create(request);
    }

    @GetMapping(END_POINT)
    @Override
    public ResponseEntity<Collection<ProviderResource>> getAll() {
        return super.getAll();
    }

    @PostMapping(END_POINT+"/id/{id}/update")
    @Override
    public ResponseEntity<ProviderResource> update(@RequestBody ProviderRequest request, @PathVariable Long id) {
        return super.update(request, id);
    }

    @DeleteMapping(END_POINT+"/id/{id}/delete")
    @Override
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
