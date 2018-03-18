package com.sison.rsvp.entity;

import com.sison.rsvp.dtoadapter.DateToMillisecondAdapter;
import com.sison.rsvp.persistence.Identifiable;
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
 * Entity definition for Events
 *
 * @author Mark
 */
@Entity
@Table(name = "EVENT")
public class Event implements Serializable, Identifiable<Integer> {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EVENT_DATE")
    @JohnzonProperty("date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JohnzonConverter(DateToMillisecondAdapter.class)
    private Date date;

    @OneToMany(mappedBy = "event")
    private Set<Invitation> guestList = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Registration> registrations = new HashSet<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
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

    public Set<Invitation> getGuestList() {
        return guestList;
    }

    public void setGuestList(Set<Invitation> guestList) {
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
