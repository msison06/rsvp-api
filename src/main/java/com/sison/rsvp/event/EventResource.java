/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.event;

import com.sison.rsvp.entity.Event;
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
@Path("/events")
@RolesAllowed({"rsvpadmin"})
public class EventResource extends CrudResource<Event, Integer> {

    @Inject
    protected EventService eventService;

    @PostConstruct
    private void postConstruct() {
        setCrudService(eventService);
    }
}
