/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.persistence.RsvpCrudService;
import javax.ejb.Stateless;

/**
 *
 * @author Mark
 */
@Stateless
public class RegistrationService extends RsvpCrudService<Registration, Integer> {

    public RegistrationService() {
        super(Registration.class);
    }

}