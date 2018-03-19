/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Invitation;
import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.persistence.RsvpCrudService;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Service layer for basic crud on the registration entity
 *
 * @author Mark
 */
@Stateless
public class RegistrationService extends RsvpCrudService<Registration, Integer> {

    public RegistrationService() {
        super(Registration.class);
    }

    /**
     * Retrieve all registrations for a given invite
     *
     * @param invite the invitation record
     * @return
     */
    public List<Registration> getByInvite(Invitation invite) {
        //Registrations match invite by firstname/lastname and same event.
        return em.createQuery("select r from Registration as r where r.event.id = :id and r.firstName = :firstName and r.lastName = :lastName")
                .setParameter("id", invite.getEvent().getId())
                .setParameter("firstName", invite.getFirstName())
                .setParameter("lastName", invite.getLastName())
                .getResultList();
    }

    /**
     * Retrieve all registrations for a given event
     *
     * @param eventId the id of the event
     * @return
     */
    public List<Registration> getByEvent(Integer eventId) {
        return em.createQuery("select r from Registration as r where r.event.id = :id")
                .setParameter("id", eventId)
                .getResultList();
    }
}
