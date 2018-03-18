package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Guest;
import com.sison.rsvp.entity.InvitedGuest;
import com.sison.rsvp.entity.Registration;
import java.io.Serializable;
import java.util.List;

/**
 * ConfirmedGuests are guests that were both invited and have already registered
 *
 * @author Mark
 */
public class ConfirmedGuest extends Guest implements Serializable {

    private Integer estAdditionalGuests;
    private List<Registration> registrations;

    public ConfirmedGuest(InvitedGuest inv, List<Registration> registrations) {
        this.firstName = inv.getFirstName();
        this.lastName = inv.getLastName();
        estAdditionalGuests = inv.getEstAdditionalGuests();
        this.registrations = registrations;
    }

    public Integer getEstAdditionalGuests() {
        return estAdditionalGuests;
    }

    public void setEstAdditionalGuests(Integer estAdditionalGuests) {
        this.estAdditionalGuests = estAdditionalGuests;
    }

    /**
     * If a user has registered more than one time (by mistake or on purpose),
     * this wrapper will capture that. This function returns all registrations
     * for this guest.
     *
     * @return
     */
    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
