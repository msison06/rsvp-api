package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Invitation;
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
 * Business logic for administrative functionality on guests.
 *
 * @author Mark
 */
@Stateless
public class GuestService {

    @PersistenceContext(unitName = "rsvp_pu")
    protected EntityManager em;

    @Inject
    protected InvitationService invitationService;

    @Inject
    protected RegistrationService regService;

    /**
     * Gets guests that have been invited and registered for the event
     *
     * @param eventId id of the event
     * @return
     */
    public List<ConfirmedGuest> getConfirmedGuests(Integer eventId) {
        List<Invitation> invites = invitationService.getByEvent(eventId);
        List<ConfirmedGuest> confirmed;

        confirmed = invites.stream()
                .map(i -> {
                    return new ConfirmedGuest(i, regService.getByInvite(i));
                })
                .collect(Collectors.toList());

        return confirmed;
    }

    /**
     * Retrieve guests that plan to bring more guests than the user anticipated.
     *
     * @param eventId id of the event
     * @return
     */
    public List<ConfirmedGuest> getUnderestimated(Integer eventId) {
        List<ConfirmedGuest> confirmed = getConfirmedGuests(eventId);
        return confirmed.stream()
                .filter(guest -> isUnderestimated(guest))
                .collect(Collectors.toList());
    }

    /**
     * Checks an invitation against all their potential registrations to see if
     * they were underestimated
     *
     * @param eventId id of the event
     * @return
     */
    private boolean isUnderestimated(ConfirmedGuest guest) {
        for (Registration r : guest.getRegistrations()) {
            //They registered to bring more guests than the user planned for
            if (r.getAdditionalGuests() > guest.getEstAdditionalGuests()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a list of people that registered for the event but were not
     * invited
     *
     * @param eventId id of the event
     * @return
     */
    public List<Registration> getNonInvitedGuests(Integer eventId) {
        //Grab all the registrations to the event
        List<Registration> nonInvited = new LinkedList(regService.getByEvent(eventId));

        //remove all that were invited, leaving non-invited
        nonInvited.removeAll(invitedRegistrations(eventId));

        return nonInvited;
    }

    /**
     * Retrieves a list of registrations that were invited
     *
     * @param eventId id of the event
     * @return
     */
    private List<Registration> invitedRegistrations(Integer eventId) {
        List<Invitation> invites = invitationService.getByEvent(eventId);

        List<Registration> invitedRegistrations = new LinkedList<>();

        //loop over the invitations to grab all their registrations.
        invites.forEach((invite) -> {
            invitedRegistrations.addAll(regService.getByInvite(invite));
        });

        return invitedRegistrations;
    }

    /**
     * Retrieves a list of users that registered multiple times (or have the
     * same first/last name combo)
     *
     * @param eventId id of the event
     * @return
     */
    public List<List<Registration>> getDuplicateRegistrations(Integer eventId) {
        List<List<Registration>> regss = new LinkedList<>();

        //Get distinct first/last name combinations IF more than one record exists for them
        List<Object[]> nonUniqueNames = em.createQuery("select distinct r.firstName, r.lastName from Registration r where r.event.id = :id group by r.firstName, r.lastName having count(r) > 1")
                .setParameter("id", eventId)
                .getResultList();

        //For each first/last name combo, grab their registrations
        nonUniqueNames.forEach(names -> {
            List<Registration> registrations = em.createQuery("select r from Registration as r where r.firstName = :firstName and r.lastName = :lastName")
                    .setParameter("firstName", names[0])
                    .setParameter("lastName", names[1])
                    .getResultList();
            regss.add(registrations);
        });

        return regss;
    }
}
