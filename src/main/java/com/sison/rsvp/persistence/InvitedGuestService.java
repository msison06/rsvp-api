/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.persistence;

import com.sison.rsvp.entity.InvitedGuest;
import javax.ejb.Stateless;

/**
 *
 * @author Mark
 */
@Stateless
public class InvitedGuestService extends RsvpCrudService<InvitedGuest, Integer> {

    public InvitedGuestService() {
        super(InvitedGuest.class);
    }

}
