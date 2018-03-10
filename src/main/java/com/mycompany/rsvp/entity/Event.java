/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.entity;

import com.mycompany.rsvp.dtoadapter.DateToMillisecondAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.apache.johnzon.mapper.JohnzonConverter;
import org.apache.johnzon.mapper.JohnzonProperty;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "EVENT")
public class Event implements Serializable {

    @Id
    private Long id;

    private String name;

    @Column(name = "EVENT_DATE")
    @JohnzonProperty("date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JohnzonConverter(DateToMillisecondAdapter.class)
    private Date date;

    @OneToMany(mappedBy = "event")
    private Set<InvitedGuest> guestList = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Registration> registrations = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<InvitedGuest> getGuestList() {
        return guestList;
    }

    public void setGuestList(Set<InvitedGuest> guestList) {
        this.guestList = guestList;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
