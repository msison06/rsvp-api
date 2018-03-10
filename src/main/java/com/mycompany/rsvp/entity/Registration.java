/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.entity;

import com.mycompany.rsvp.dtoadapter.DateToMillisecondAdapter;
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
public class Registration implements Serializable {

    @Id
    private Long id;

    @Column(name = "REG_DATE")
    @JohnzonProperty("date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JohnzonConverter(DateToMillisecondAdapter.class)
    private Date date;

    @OneToOne
    private RegisteredGuest guestInfo;

    @JohnzonIgnore
    @ManyToOne(optional = false)
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
