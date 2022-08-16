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
    @SubclassMapping(source = AddressEntity.class, target = Address.class)
    @SubclassMapping(source = ClientEntity.class, target = Client.class)
    @SubclassMapping(source = CollaboratorEntity.class, target = Collaborator.class)
    @SubclassMapping(source = MissionEntity.class, target = Mission.class)
    @SubclassMapping(source = ProviderEntity.class, target = Provider.class)
    @SubclassMapping(source = SiteEntity.class, target = Site.class)
    BusinessComponent map(EntityComponent source);


    // Business -> Entity
    @SubclassMapping(target = AddressEntity.class, source = Address.class)
    @SubclassMapping(target = ClientEntity.class, source = Client.class)
    @SubclassMapping(target = CollaboratorEntity.class, source = Collaborator.class)
    @SubclassMapping(target = MissionEntity.class, source = Mission.class)
    @SubclassMapping(target = ProviderEntity.class, source = Provider.class)
    @SubclassMapping(target = SiteEntity.class, source = Site.class)
    EntityComponent map(BusinessComponent source);
}
