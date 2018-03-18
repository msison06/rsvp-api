package com.sison.rsvp.guest;

import com.sison.rsvp.entity.InvitedGuest;
import com.sison.rsvp.ws.CrudResource;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Resource layer for invitations
 *
 * @author Mark
 */
@Stateless
@Path("/invitedguests")
@RolesAllowed({"rsvpadmin"})
public class InvitedGuestResource extends CrudResource<InvitedGuest, Integer> {

    @Inject
    protected InvitedGuestService invitedGuestService;

    @PostConstruct
    private void postConstruct() {
        //set superclass's crud service in post construct so dependencies have
        //already been injected
        setCrudService(invitedGuestService);
    }
}
