package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.entity.MissionEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.MissionRepository;
import com.gallia.planif.exception.EntityNotFoundException;
import com.gallia.planif.service.MissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Optional;

public class MissionServiceImpl implements MissionService {
    private final Logger LOGGER = LoggerFactory.getLogger(MissionServiceImpl.class);

    private final BusinessEntityMapper mapper;

    private final MissionRepository repository;

    public MissionServiceImpl(BusinessEntityMapper mapper, MissionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public Mission create(Mission mission) {
        LOGGER.info("Create mission '{}'", mission.toString());
        MissionEntity missionEntity = repository.save(mapper.map(mission));
        return mapper.map(missionEntity);
    }

    @Override
    public Collection<Mission> getAll() {
        LOGGER.info("Get all missions");
        return repository.findAll().stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public Mission update(Mission mission) {
        LOGGER.info("Update mission '{}'", mission.getId());
        Optional<MissionEntity> byId = repository.findById(mission.getId());
        if(byId.isEmpty()) {
            throw new EntityNotFoundException("mission", mission.getId());
        }
        MissionEntity save = repository.save(mapper.map(mission));
        return mapper.map(save);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Delete mission '{}'", id);
        Optional<MissionEntity> entity = repository.findById(id);
        if(entity.isEmpty()) {
            throw new EntityNotFoundException("mission", id);
        }
        repository.delete(entity.get());
    }
}
