/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Registration;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Mark
 */
@Stateless
public class GuestService {

    @Inject
    protected InvitedGuestService invGuestService;

    @Inject
    protected RegisteredGuestService regGuestService;

    public List<ExpectedGuest> getExpectedGuests(Integer eventId) {
        return new LinkedList<>();
    }

    public List<Registration> getNonInvitedGuests(Integer eventId) {
        return new LinkedList<>();
    }

    public List<ExpectedGuest> getUnderestimated(Integer eventId) {
        return new LinkedList<>();
    }

    public List<List<Registration>> getDuplicateRegistrations(Integer eventId) {
        return new LinkedList<>();
    }
}
