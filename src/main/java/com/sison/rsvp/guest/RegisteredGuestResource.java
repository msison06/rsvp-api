/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.guest;

import com.sison.rsvp.entity.RegisteredGuest;
import com.sison.rsvp.ws.CrudResource;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Mark
 */
@Stateless
@RolesAllowed({"rsvpadmin"})
public class RegisteredGuestResource extends CrudResource<RegisteredGuest, Integer> {

    @Inject
    protected RegisteredGuestService regGuestService;

    @PostConstruct
    private void postConstruct() {
        setCrudService(regGuestService);
    }
}
