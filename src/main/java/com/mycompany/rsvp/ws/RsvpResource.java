package com.mycompany.rsvp.ws;

import com.mycompany.rsvp.entity.Event;
import com.mycompany.rsvp.entity.InvitedGuest;
import com.mycompany.rsvp.entity.RegisteredGuest;
import com.mycompany.rsvp.entity.Registration;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @PersistenceUnit(name = "rsvp_pu")
    EntityManagerFactory emf;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/info/id/{id}")
    public Response eventInfo(@PathParam("id") Integer id) {

        EntityManager em = emf.createEntityManager();

        Event event = em.find(Event.class, id);

        return Response.ok(event).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response register(Registration registration) {
        EntityManager em = emf.createEntityManager();

        em.persist(registration.getGuestInfo());

        Integer eventId = registration.getEvent().getId();
        Event event = em.find(Event.class, eventId);
        registration.setEvent(event);

        em.persist(registration);

        return Response.ok(registration).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createEvent")
    public Response register(Event event) {
        EntityManager em = emf.createEntityManager();

        em.persist(event);

        return Response.ok(event).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public Response test() {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select e from Event as e");
        List<Event> events = q.getResultList();

        return Response.ok(events.toArray()).build();
    }

}
