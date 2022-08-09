package com.gallia.planif.dao.repository;

import com.gallia.planif.dao.model.entity.CollaboratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<CollaboratorEntity, Long> {
}
