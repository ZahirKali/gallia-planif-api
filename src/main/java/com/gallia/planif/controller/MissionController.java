package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.business.Site;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.MissionRequest;
import com.gallia.planif.dao.model.request.SiteRequest;
import com.gallia.planif.dao.model.resource.MissionResource;
import com.gallia.planif.dao.model.resource.SiteResource;
import com.gallia.planif.service.impl.MissionServiceImpl;
import com.gallia.planif.service.impl.SiteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MissionController extends AbstractController<Mission, MissionRequest, MissionResource> {

    private final String END_POINT = "/mission";

    public MissionController(BusinessRequestMapper requestMapper, BusinessResourceMapper resourceMapper, MissionServiceImpl service) {
        super(requestMapper, resourceMapper, service);
    }

    @PostMapping(END_POINT)
    @Override
    public ResponseEntity<MissionResource> create(@RequestBody MissionRequest request) {
        return super.create(request);
    }

    @GetMapping(END_POINT)
    @Override
    public ResponseEntity<Collection<MissionResource>> getAll() {
        return super.getAll();
    }

    @PostMapping(END_POINT + "/id/{id}/update")
    @Override
    public ResponseEntity<MissionResource> update(@RequestBody MissionRequest request, @PathVariable Long id) {
        return super.update(request, id);
    }

    @DeleteMapping(END_POINT + "/id/{id}/delete")
    @Override
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }
}
