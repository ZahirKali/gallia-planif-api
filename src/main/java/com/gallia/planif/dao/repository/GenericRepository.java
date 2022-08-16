package com.gallia.planif.dao.repository;

import com.gallia.planif.dao.model.entity.EntityComponent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends EntityComponent, Long> extends CrudRepository<T, Long> {
}
