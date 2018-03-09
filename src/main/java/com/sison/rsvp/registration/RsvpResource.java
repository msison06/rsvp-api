package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.entity.Registration;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource layer for general users to rsvp
 *
 * @author Mark
 */
@Stateless
@Path("")
public class RsvpResource {

    @Inject
    protected RsvpService rsvpService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/info/id/{id}")
    public Response eventInfo(@PathParam("id") Integer id) {
        Event event = rsvpService.eventInfo(id);

        return Response.ok(event).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response register(Registration registration) {
        registration = rsvpService.register(registration);
        return Response.ok(registration).build();
    }
}
