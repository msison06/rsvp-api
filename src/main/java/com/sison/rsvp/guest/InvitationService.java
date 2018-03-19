/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Invitation;
import com.sison.rsvp.persistence.RsvpCrudService;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Service layer for basic crud on the invitation entity
 *
 * @author Mark
 */
@Stateless
public class InvitationService extends RsvpCrudService<Invitation, Integer> {

    public InvitationService() {
        super(Invitation.class);
    }

    /**
     * Get a list of invitations based on the event id
     *
     * @param eventId id of the event
     * @return
     */
    public List<Invitation> getByEvent(Integer eventId) {
        return em.createQuery("select g from Invitation as g where g.event.id = :id")
                .setParameter("id", eventId)
                .getResultList();
    }
}
