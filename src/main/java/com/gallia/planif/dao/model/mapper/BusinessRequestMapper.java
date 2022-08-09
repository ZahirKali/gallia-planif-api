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
    Address map(AddressRequest source);
    Client map(ClientRequest source);
    Collaborator map(CollaboratorRequest source);
    Mission map(MissionRequest source);
    Provider map(ProviderRequest source);
    Site map(SiteRequest source);


    // Business -> Request
    AddressRequest map(Address source);
    ClientRequest map(Client source);
    CollaboratorRequest map(Collaborator source);
    MissionRequest map(Mission source);
    ProviderRequest map(Provider source);
    SiteRequest map(Site source);
}
