package com.sison.rsvp.ws;

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
 * Generic resource layer for crud services
 *
 * @author Mark
 * @param <E> Entity class
 * @param <I> id of the entity
 */
public abstract class CrudResource<E extends Identifiable<I>, I> {

    protected CrudService<E, I> crudService;

    /**
     * Set the crud service to use for the resource
     *
     * @param crudService
     */
    public void setCrudService(CrudService<E, I> crudService) {
        this.crudService = crudService;
    }

    /**
     * Endpoint to create an entity
     *
     * @param entity
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response create(E entity) {
        entity = crudService.create(entity);

        return Response.ok(entity).build();
    }

    /**
     * Endpoint to retrieve all records for an entity
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response getAll() {
        List<E> entities = crudService.getAll();

        return Response.ok(entities.toArray()).build();
    }

    /**
     * Retrieve one record with a given id
     *
     * @param id
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response get(@PathParam("id") I id) {
        E entity = crudService.get(id);

        return Response.ok(entity).build();
    }

    /**
     * Edit an entity
     *
     * @param entity entity to edit
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response update(E entity) {
        entity = crudService.update(entity.getId(), entity);

        return Response.ok(entity).build();
    }

    /**
     * Delete an entity
     *
     * @param id if of entity to delete
     * @return
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response delete(@PathParam("id") I id) {
        crudService.delete(id);

        return Response.ok().build();
    }
}
