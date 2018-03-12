/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.sequence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mark
 */
@Stateless
public class SequenceService {

    @PersistenceContext(unitName = "rsvp_pu")
    private EntityManager em;

    public Sequence getSequence(Class entityClass) {
        return new SqliteSequence(em, entityClass);
    }
}
