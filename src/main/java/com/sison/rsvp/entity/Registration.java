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
public class Registration implements Serializable, Identifiable<Integer> {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "REG_DATE")
    @JohnzonProperty("date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JohnzonConverter(DateToMillisecondAdapter.class)
    private Date date;

    @OneToOne(mappedBy = "registration", optional = false, orphanRemoval = true)
    private RegisteredGuest guestInfo;

    @ManyToOne(optional = false)
    private Event event;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RegisteredGuest getGuestInfo() {
        return guestInfo;
    }

    public void setGuestInfo(RegisteredGuest guestInfo) {
        this.guestInfo = guestInfo;
    }

    @JohnzonIgnore()
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
