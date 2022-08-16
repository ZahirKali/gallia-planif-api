package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Client;
import com.gallia.planif.dao.model.entity.ClientEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends AbstractGenericService<Client, ClientEntity> {

    public ClientServiceImpl(GenericRepository<ClientEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }
}
