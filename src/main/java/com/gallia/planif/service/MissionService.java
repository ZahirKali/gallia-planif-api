package com.gallia.planif.service;

import com.gallia.planif.dao.model.business.Mission;

import java.util.Collection;

public interface MissionService {

    /**
     * create Mission
     * @param Mission Mission
     * @return created Mission
     */
    Mission create(Mission Mission);

    Collection<Mission> getAll();

    /**
     * update Mission
     *
     * @param Mission Mission
     * @return updated Mission
     */
    Mission update(Mission Mission);

    /**
     * delete Mission
     * @param id Mission id
     */
    void delete(Long id);
}
