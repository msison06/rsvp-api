package com.mycompany.rsvp.ws;

import com.mycompany.rsvp.entity.Guest;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
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
@Path("")
public class RsvpResource {

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/info/id/{id}")
    public Response eventInfo(@PathParam("id") Long id) {
        return Response.ok().build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response register(Guest guest) {
        return Response.ok().build();
    }
}
