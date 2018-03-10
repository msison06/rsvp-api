/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.johnzon.mapper.JohnzonIgnore;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "INVITED_GUEST")
public class InvitedGuest extends Guest {

    @JohnzonIgnore
    @ManyToOne(optional = false)
    private Event event;

    private Integer estAdditionalGuests;

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
}
