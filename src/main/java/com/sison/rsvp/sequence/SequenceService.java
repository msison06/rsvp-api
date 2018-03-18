package com.sison.rsvp.sequence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Serves up sequences for different entities.
 *
 * @author Mark
 */
@Stateless
public class SequenceService {

    @PersistenceContext(unitName = "rsvp_pu")
    private EntityManager em;

    /**
     * Retrieve the sequence for a given entity
     *
     * @param entityClass class to retrieve sequence for
     * @return
     */
    public Sequence getSequence(Class entityClass) {
        return new SqliteSequence(em, entityClass);
    }
}
