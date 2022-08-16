package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Provider;
import com.gallia.planif.dao.model.entity.ProviderEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends AbstractGenericService<Provider, ProviderEntity> {

    public ProviderServiceImpl(GenericRepository<ProviderEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }
}
