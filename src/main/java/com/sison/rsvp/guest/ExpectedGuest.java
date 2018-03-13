/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.entity.Guest;
import java.io.Serializable;

/**
 *
 * @author Mark
 */
public class ExpectedGuest extends Guest implements Serializable {

    private Event event;
    private Integer estAdditionalGuests;
    private Integer additionalGuests;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
