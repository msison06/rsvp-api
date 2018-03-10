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
@Table(name = "INVITED_GUEST")
public class InvitedGuest extends Guest {

    private Integer estAdditionalGuests;
    private String guestPasscode;
}
