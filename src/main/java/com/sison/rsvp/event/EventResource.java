package com.sison.rsvp.event;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.ws.CrudResource;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Resource layer for events
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
        //set superclass's crud service in post construct so dependencies have
        //already been injected
        setCrudService(eventService);
    }
}
