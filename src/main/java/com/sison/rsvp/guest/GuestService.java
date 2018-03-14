/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.guest;

import com.sison.rsvp.entity.InvitedGuest;
import com.sison.rsvp.entity.RegisteredGuest;
import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.registration.RegistrationService;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mark
 */
@Stateless
public class GuestService {

    @PersistenceContext(unitName = "rsvp_pu")
    protected EntityManager em;

    @Inject
    protected InvitedGuestService invGuestService;

    @Inject
    protected RegisteredGuestService regGuestService;

    private final String EXPECTED = "select inv, reg from "
            + "InvitedGuest as inv, RegisteredGuest as reg "
            + "where "
            + "inv.firstName = reg.firstName "
            + "and inv.lastName = reg.lastName "
            + "and reg.registration.event.id = :id "
            + "and inv.event.id = :id ";

    private final String AND_UNDERESTIMATED = "and inv.estAdditionalGuests < reg.additionalGuests ";

    public List<ExpectedGuest> getExpectedGuests(Integer eventId) {

        List<Object[]> result = em.createQuery(EXPECTED)
                .setParameter("id", eventId)
                .getResultList();

        return convertToExpectedGuests(result);
    }

    public List<ExpectedGuest> getUnderestimated(Integer eventId) {
        List<Object[]> result = em.createQuery(EXPECTED + AND_UNDERESTIMATED)
                .setParameter("id", eventId)
                .getResultList();

        return convertToExpectedGuests(result);
    }

    private List<ExpectedGuest> convertToExpectedGuests(List<Object[]> guests) {
        List<ExpectedGuest> expectedGuests;

        expectedGuests = guests.stream().map(g -> {
            return new ExpectedGuest((InvitedGuest) g[0], (RegisteredGuest) g[1]);
        }).collect(Collectors.toList());

        return expectedGuests;
    }

    public List<Registration> getNonInvitedGuests(Integer eventId) {
        String selectWhereNotExist = "select r.guestInfo from Registration as r where NOT EXISTS(" + EXPECTED + ")";

        List<Registration> registrations = em.createQuery(selectWhereNotExist)
                .setParameter("id", eventId)
                .getResultList();

        return registrations;
    }

    @Inject
    protected RegistrationService regService;

    public List<List<Registration>> getDuplicateRegistrations(Integer eventId) {
        List<List<Registration>> regss = new LinkedList<>();
//select rs from Registration rs where exists
//        List<Registration> registrations = em.createQuery("select r from Registration as r where r.event.id = :id group by r.guestInfo.firstName, r.guestInfo.lastName having count(r) > 1")
//                .setParameter("id", eventId)
//                .getResultList();

        List<Object[]> distinctNames = em.createQuery("select distinct r.guestInfo.firstName, r.guestInfo.lastName from Registration r where r.event.id = :id group by r.guestInfo.firstName, r.guestInfo.lastName having count(r) > 1")
                .setParameter("id", eventId)
                .getResultList();

        distinctNames.forEach(names -> {
            List<Registration> registrations = em.createQuery("select r from Registration as r where r.guestInfo.firstName = :firstName and r.guestInfo.lastName = :lastName")
                    .setParameter("firstName", names[0])
                    .setParameter("lastName", names[1])
                    .getResultList();
            regss.add(registrations);
        });

        return regss;
    }
}
