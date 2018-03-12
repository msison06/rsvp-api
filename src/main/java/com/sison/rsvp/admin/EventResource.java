/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.admin;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.persistence.EventService;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mark
 */
@Stateless
@Path("/event")
public class EventResource {

    @Inject
    protected EventService eventService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response create(Event event) {
        event = eventService.create(event);

        return Response.ok(event).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response listEvents() {
        List<Event> events = eventService.getAll();

        return Response.ok(events.toArray()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response eventInfo(@PathParam("id") Integer id) {
        Event event = eventService.get(id);

        return Response.ok(event).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response event(Event event) {
        event = eventService.update(event.getId(), event);

        return Response.ok(event).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response delete(@PathParam("id") Integer id) {
        eventService.delete(id);

        return Response.ok().build();
    }

}
