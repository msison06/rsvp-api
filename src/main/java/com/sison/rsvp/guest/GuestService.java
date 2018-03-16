package com.sison.rsvp.guest;

import com.sison.rsvp.entity.InvitedGuest;
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
    protected RegistrationService regService;

    public List<ConfirmedGuest> getConfirmedGuests(Integer eventId) {
        List<InvitedGuest> invites = invGuestService.getByEvent(eventId);
        List<ConfirmedGuest> confirmed;

        confirmed = invites.stream()
                .map(i -> {
                    return new ConfirmedGuest(i, regService.getByInvite(i));
                })
                .collect(Collectors.toList());

        return confirmed;
    }

    public List<ConfirmedGuest> getUnderestimated(Integer eventId) {
        List<ConfirmedGuest> confirmed = getConfirmedGuests(eventId);
        return confirmed.stream()
                .filter(guest -> isUnderestimated(guest))
                .collect(Collectors.toList());
    }

    private boolean isUnderestimated(ConfirmedGuest guest) {
        for (Registration r : guest.getRegistrations()) {
            if (r.getAdditionalGuests() > guest.getEstAdditionalGuests()) {
                return true;
            }
        }
        return false;
    }

    public List<Registration> getNonInvitedGuests(Integer eventId) {
        List<Registration> nonInvited = new LinkedList(regService.getByEvent(eventId));
        nonInvited.removeAll(invitedRegistrations(eventId));

        return nonInvited;
    }

    private List<Registration> invitedRegistrations(Integer eventId) {
        List<InvitedGuest> invites = invGuestService.getByEvent(eventId);

        List<Registration> invitedRegistrations = new LinkedList<>();
        invites.forEach((invite) -> {
            invitedRegistrations.addAll(regService.getByInvite(invite));
        });

        return invitedRegistrations;
    }

    public List<List<Registration>> getDuplicateRegistrations(Integer eventId) {
        List<List<Registration>> regss = new LinkedList<>();

        List<Object[]> distinctNames = em.createQuery("select distinct r.firstName, r.lastName from Registration r where r.event.id = :id group by r.firstName, r.lastName having count(r) > 1")
                .setParameter("id", eventId)
                .getResultList();

        distinctNames.forEach(names -> {
            List<Registration> registrations = em.createQuery("select r from Registration as r where r.firstName = :firstName and r.lastName = :lastName")
                    .setParameter("firstName", names[0])
                    .setParameter("lastName", names[1])
                    .getResultList();
            regss.add(registrations);
        });

        return regss;
    }
}
