/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.ws.CrudResource;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author Mark
 */
@Stateless
@Path("/regisrations")
@RolesAllowed({"rsvpadmin"})
public class RegistrationResource extends CrudResource<Registration, Integer> {

    @Inject
    protected RegistrationService registrationService;

    @PostConstruct
    private void postConstruct() {
        setCrudService(registrationService);
    }
}
