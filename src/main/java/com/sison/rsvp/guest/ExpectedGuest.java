/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Guest;
import com.sison.rsvp.entity.InvitedGuest;
import com.sison.rsvp.entity.RegisteredGuest;
import com.sison.rsvp.entity.Registration;
import java.io.Serializable;

/**
 *
 * @author Mark
 */
public class ExpectedGuest extends Guest implements Serializable {

    private Integer estAdditionalGuests;
    private Integer additionalGuests;

    private Registration registration;

    public ExpectedGuest(InvitedGuest inv, RegisteredGuest reg) {
        this.setFirstName(inv.getFirstName());
        this.setLastName(inv.getLastName());
        estAdditionalGuests = inv.getEstAdditionalGuests();
        additionalGuests = reg.getAdditionalGuests();
    }

    public Integer getEstAdditionalGuests() {
        return estAdditionalGuests;
    }

    public void setEstAdditionalGuests(Integer estAdditionalGuests) {
        this.estAdditionalGuests = estAdditionalGuests;
    }

    public Integer getAdditionalGuests() {
        return additionalGuests;
    }

    public void setAdditionalGuests(Integer additionalGuests) {
        this.additionalGuests = additionalGuests;
    }
}
