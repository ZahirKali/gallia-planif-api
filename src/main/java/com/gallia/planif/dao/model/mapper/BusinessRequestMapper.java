package com.gallia.planif.dao.model.mapper;

import com.gallia.planif.dao.model.business.*;
import com.gallia.planif.dao.model.entity.*;
import com.gallia.planif.dao.model.request.*;
import com.gallia.planif.dao.model.resource.*;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface BusinessRequestMapper {

    // Request ->  Business
    @SubclassMapping(source = AddressRequest.class, target = Address.class)
    @SubclassMapping(source = ClientRequest.class, target = Client.class)
    @SubclassMapping(source = CollaboratorRequest.class, target = Collaborator.class)
    @SubclassMapping(source = MissionRequest.class, target = Mission.class)
    @SubclassMapping(source = ProviderRequest.class, target = Provider.class)
    @SubclassMapping(source = SiteRequest.class, target = Site.class)
    BusinessComponent map(RequestComponent source);


    // Business -> Request
    @SubclassMapping(target = AddressRequest.class, source = Address.class)
    @SubclassMapping(target = ClientRequest.class, source = Client.class)
    @SubclassMapping(target = CollaboratorRequest.class, source = Collaborator.class)
    @SubclassMapping(target = MissionRequest.class, source = Mission.class)
    @SubclassMapping(target = ProviderRequest.class, source = Provider.class)
    @SubclassMapping(target = SiteRequest.class, source = Site.class)
    RequestComponent map(BusinessComponent source);
}
