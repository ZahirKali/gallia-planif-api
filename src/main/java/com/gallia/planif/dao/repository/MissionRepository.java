package com.gallia.planif.dao.repository;

import com.gallia.planif.dao.model.entity.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends GenericRepository<MissionEntity, Long> {
}
