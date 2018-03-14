package com.sison.rsvp.guest;

import com.sison.rsvp.entity.Registration;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
@Path("/guests")
@RolesAllowed({"rsvpadmin"})
public class GuestResource {

    @Inject
    protected GuestService guestService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/expected/eventid/{id}")
    public Response getExpectedGuests(@PathParam("id") Integer id) {
        List<ExpectedGuest> expected = guestService.getExpectedGuests(id);
        return Response.ok(expected.toArray()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/noninvited/eventid/{id}")
    public Response getNonInvitedGuests(@PathParam("id") Integer id) {
        List<Registration> registrations = guestService.getNonInvitedGuests(id);
        return Response.ok(registrations.toArray()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/underestimated/eventid/{id}")
    public Response getUnderestimated(@PathParam("id") Integer id) {
        List<ExpectedGuest> underestimated = guestService.getUnderestimated(id);
        return Response.ok(underestimated.toArray()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/duplicates/eventid/{id}")
    public Response getDuplicateRegistrations(@PathParam("id") Integer id) {
        List<List<Registration>> dupes = guestService.getDuplicateRegistrations(id);
        return Response.ok(dupes.toArray()).build();
    }
}
