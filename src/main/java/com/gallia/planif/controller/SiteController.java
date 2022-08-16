package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Site;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.SiteRequest;
import com.gallia.planif.dao.model.resource.SiteResource;
import com.gallia.planif.service.impl.SiteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SiteController extends AbstractController<Site, SiteRequest, SiteResource> {

    private final String END_POINT = "/site";

    public SiteController(BusinessRequestMapper requestMapper, BusinessResourceMapper resourceMapper, SiteServiceImpl service) {
        super(requestMapper, resourceMapper, service);
    }

    @PostMapping(END_POINT)
    @Override
    public ResponseEntity<SiteResource> create(@RequestBody SiteRequest request) {
        return super.create(request);
    }

    @GetMapping(END_POINT)
    @Override
    public ResponseEntity<Collection<SiteResource>> getAll() {
        return super.getAll();
    }

    @PostMapping(END_POINT + "/id/{id}/update")
    @Override
    public ResponseEntity<SiteResource> update(@RequestBody SiteRequest request, @PathVariable Long id) {
        return super.update(request, id);
    }

    @DeleteMapping(END_POINT + "/id/{id}/delete")
    @Override
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
