package com.gallia.planif.model.mapper;

import com.gallia.planif.model.business.BusinessComponent;
import com.gallia.planif.model.entity.EntityComponent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessEntityMapper {
    BusinessEntityMapper INSTANCE = Mappers.getMapper(BusinessEntityMapper.class);

    BusinessComponent map(EntityComponent source);

    EntityComponent map(BusinessComponent source);

}
