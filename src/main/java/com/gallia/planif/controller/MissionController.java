package com.gallia.planif.controller;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.mapper.BusinessRequestMapper;
import com.gallia.planif.dao.model.mapper.BusinessResourceMapper;
import com.gallia.planif.dao.model.request.MissionRequest;
import com.gallia.planif.dao.model.resource.CollaboratorResource;
import com.gallia.planif.dao.model.resource.MissionResource;
import com.gallia.planif.service.MissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private final BusinessRequestMapper requestMapper;
    private final BusinessResourceMapper resourceMapper;
    private final MissionService missionService;

    public MissionController(BusinessRequestMapper mapper,
                             BusinessResourceMapper resourceMapper,
                             MissionService missionService) {
        this.requestMapper = mapper;
        this.resourceMapper = resourceMapper;
        this.missionService = missionService;
    }

    @PostMapping
    public ResponseEntity<MissionResource> create(@RequestBody MissionRequest request) {
        Mission mission = missionService.create(requestMapper.map(request));
        return ResponseEntity.ok(resourceMapper.map(mission));
    }
}
