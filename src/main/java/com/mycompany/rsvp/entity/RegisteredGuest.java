/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.johnzon.mapper.JohnzonIgnore;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "REGISTERED_GUEST")
public class RegisteredGuest extends Guest {

    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID")
    private Registration registration;

    @Column(name = "ADDITIONAL_GUESTS")
    private Integer additionalGuests;

    @JohnzonIgnore()
    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Integer getAdditionalGuests() {
        return additionalGuests;
    }

    public void setAdditionalGuests(Integer additionalGuests) {
        this.additionalGuests = additionalGuests;
    }
}
