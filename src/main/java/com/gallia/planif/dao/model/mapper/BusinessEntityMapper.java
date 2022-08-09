package com.gallia.planif.dao.model.mapper;

import com.gallia.planif.dao.model.business.*;
import com.gallia.planif.dao.model.entity.*;
import com.gallia.planif.dao.model.request.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface BusinessEntityMapper {
    // Entity ->  Business
    Address map(AddressEntity source);
    Client map(ClientEntity source);
    Collaborator map(CollaboratorEntity source);
    Mission map(MissionEntity source);
    Provider map(ProviderEntity source);
    Site map(SiteEntity source);


    // Business -> Entity
    AddressEntity map(Address source);
    ClientEntity map(Client source);
    CollaboratorEntity map(Collaborator source);
    MissionEntity map(Mission source);
    ProviderEntity map(Provider source);
    SiteEntity map(Site source);

}
