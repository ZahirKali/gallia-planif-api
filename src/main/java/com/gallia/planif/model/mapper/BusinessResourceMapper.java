package com.gallia.planif.model.mapper;

import com.gallia.planif.model.business.BusinessComponent;
import com.gallia.planif.model.resource.ResourceComponent;
import org.mapstruct.Mapper;

@Mapper
public interface BusinessResourceMapper {

    ResourceComponent map(BusinessComponent source);

    BusinessComponent map(ResourceComponent source);
}
