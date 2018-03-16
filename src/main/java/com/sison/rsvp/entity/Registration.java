/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.entity;

import com.sison.rsvp.dtoadapter.DateToMillisecondAdapter;
import com.sison.rsvp.persistence.Identifiable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.apache.johnzon.mapper.JohnzonConverter;
import org.apache.johnzon.mapper.JohnzonIgnore;
import org.apache.johnzon.mapper.JohnzonProperty;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "REGISTRATION")
public class Registration extends Guest implements Serializable, Identifiable<Integer> {

    @Column(name = "REG_DATE")
    @JohnzonProperty("date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JohnzonConverter(DateToMillisecondAdapter.class)
    private Date date;

    @ManyToOne(optional = false)
    private Event event;

    @Column(name = "ADDITIONAL_GUESTS")
    private Integer additionalGuests;

    public Registration() {
        additionalGuests = 0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JohnzonIgnore()
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Integer getAdditionalGuests() {
        return additionalGuests;
    }

    public void setAdditionalGuests(Integer additionalGuests) {
        this.additionalGuests = additionalGuests;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registration other = (Registration) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
