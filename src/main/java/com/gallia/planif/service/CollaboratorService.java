package com.gallia.planif.service;

import com.gallia.planif.dao.model.business.Collaborator;

import java.util.Collection;

public interface CollaboratorService {

    /**
     * create collaborator
     * @param collaborator collaborator
     * @return created collaborator
     */
    Collaborator create(Collaborator collaborator);

    Collection<Collaborator> getAll();

    /**
     * update collaborator
     *
     * @param collaborator collaborator
     * @return updated collaborator
     */
    Collaborator update(Collaborator collaborator);

    /**
     * delete collaborator
     * @param id collaborator id
     */
    void delete(Long id);
}
