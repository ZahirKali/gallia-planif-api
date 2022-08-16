package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Mission;
import com.gallia.planif.dao.model.entity.MissionEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

@Service
public class MissionServiceImpl extends AbstractGenericService<Mission, MissionEntity> {

    public MissionServiceImpl(GenericRepository<MissionEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }
}
