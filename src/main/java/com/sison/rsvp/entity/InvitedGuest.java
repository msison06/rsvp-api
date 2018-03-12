/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Column(name = "EVENT")
    @ManyToOne(optional = false)
    private Event event;

    @Column(name = "EST_ADDITIONAL_GUESTS")
    private Integer estAdditionalGuests;

    @JohnzonIgnore
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
