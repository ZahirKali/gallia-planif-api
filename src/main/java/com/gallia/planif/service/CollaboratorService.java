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

}
