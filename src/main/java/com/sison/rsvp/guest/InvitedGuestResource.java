package com.sison.rsvp.guest;

import com.sison.rsvp.entity.InvitedGuest;
import com.sison.rsvp.ws.CrudResource;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
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
        setCrudService(invitedGuestService);
    }
}
