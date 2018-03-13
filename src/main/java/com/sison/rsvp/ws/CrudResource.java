/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.ws;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.persistence.CrudService;
import com.sison.rsvp.persistence.Identifiable;
import java.util.List;
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
public abstract class CrudResource<E extends Identifiable<I>, I> {

    protected CrudService<E, I> crudService;

    public void setCrudService(CrudService<E, I> crudService) {
        this.crudService = crudService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response create(E entity) {
        entity = crudService.create(entity);

        return Response.ok(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response getAll() {
        List<E> entities = crudService.getAll();

        return Response.ok(entities.toArray()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response eventInfo(@PathParam("id") I id) {
        E entity = crudService.get(id);

        return Response.ok(entity).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response update(E entity) {
        entity = crudService.update(entity.getId(), entity);

        return Response.ok(entity).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response delete(@PathParam("id") I id) {
        crudService.delete(id);

        return Response.ok().build();
    }
}
