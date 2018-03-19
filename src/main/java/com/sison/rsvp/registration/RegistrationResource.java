package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.ws.CrudResource;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Resource layer for registrations
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
        //set superclass's crud service in post construct so dependencies have
        //already been injected
        setCrudService(registrationService);
    }
}
