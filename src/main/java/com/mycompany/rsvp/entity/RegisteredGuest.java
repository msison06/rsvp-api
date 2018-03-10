/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Mark
 */
@Entity
@Table(name = "REGISTERED_GUEST")
public class RegisteredGuest extends Guest {

    private Integer additionalGuests;

    public Integer getAdditionalGuests() {
        return additionalGuests;
    }

    public void setAdditionalGuests(Integer additionalGuests) {
        this.additionalGuests = additionalGuests;
    }
}
