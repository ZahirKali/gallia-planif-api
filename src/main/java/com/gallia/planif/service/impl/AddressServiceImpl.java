package com.gallia.planif.service.impl;

import com.gallia.planif.dao.model.business.Address;
import com.gallia.planif.dao.model.entity.AddressEntity;
import com.gallia.planif.dao.model.mapper.BusinessEntityMapper;
import com.gallia.planif.dao.repository.GenericRepository;
import com.gallia.planif.service.AbstractGenericService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends AbstractGenericService<Address, AddressEntity> {

    public AddressServiceImpl(GenericRepository<AddressEntity, Long> repository, BusinessEntityMapper mapper) {
        super(repository, mapper);
    }
}
