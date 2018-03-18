/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.johnzon.mapper.JohnzonIgnore;

/**
 * Entity definition for invitations
 *
 * @author Mark
 */
@Entity
@Table(name = "INVITATION")
public class Invitation extends Guest {

    @Column(name = "EVENT")
    @ManyToOne(optional = false)
    private Event event;

    @Column(name = "EST_ADDITIONAL_GUESTS")
    private Integer estAdditionalGuests;

    public Invitation() {
        estAdditionalGuests = 0;
    }

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
