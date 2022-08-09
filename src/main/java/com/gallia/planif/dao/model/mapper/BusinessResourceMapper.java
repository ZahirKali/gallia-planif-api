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
    Address map(AddressResource source);
    Client map(ClientResource source);
    Collaborator map(CollaboratorResource source);
    Mission map(MissionResource source);
    Provider map(ProviderResource source);
    Site map(SiteResource source);


    // Business -> Resource
    AddressResource map(Address source);
    ClientResource map(Client source);
    CollaboratorResource map(Collaborator source);
    MissionResource map(Mission source);
    ProviderResource map(Provider source);
    SiteResource map(Site source);


}
