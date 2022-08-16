package com.gallia.planif.dao.model.mapper;

import com.gallia.planif.dao.model.business.*;
import com.gallia.planif.dao.model.resource.*;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface BusinessResourceMapper {

    // Resource ->  Business
    @SubclassMapping(source = AddressResource.class, target = Address.class)
    @SubclassMapping(source = ClientResource.class, target = Client.class)
    @SubclassMapping(source = CollaboratorResource.class, target = Collaborator.class)
    @SubclassMapping(source = MissionResource.class, target = Mission.class)
    @SubclassMapping(source = ProviderResource.class, target = Provider.class)
    @SubclassMapping(source = SiteResource.class, target = Site.class)
    BusinessComponent map(ResourceComponent source);


    // Business -> Resource
    @SubclassMapping(target = AddressResource.class, source = Address.class)
    @SubclassMapping(target = ClientResource.class, source = Client.class)
    @SubclassMapping(target = CollaboratorResource.class, source = Collaborator.class)
    @SubclassMapping(target = MissionResource.class, source = Mission.class)
    @SubclassMapping(target = ProviderResource.class, source = Provider.class)
    @SubclassMapping(target = SiteResource.class, source = Site.class)
    ResourceComponent map(BusinessComponent source);

}
