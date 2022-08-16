package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Site;
import com.gallia.planif.dao.model.entity.SiteEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl extends AbstractGenericService<Site, SiteEntity> {

    public SiteServiceImpl(GenericRepository<SiteEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }
}
