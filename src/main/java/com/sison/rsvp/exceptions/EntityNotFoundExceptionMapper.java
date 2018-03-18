package com.sison.rsvp.exceptions;

import com.sison.rsvp.validation.Problem;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Top layer exception handling for EntityNotFoundExceptions to reduce handling
 * them in code.
 *
 * @author Mark
 */
@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(EntityNotFoundException e) {
        //Pack in an error that describes that an entity wasn't found.
        //This is more for frontend developers than end users since it'll only
        //show an id
        Problem error = new Problem();
        error.setSummary("Not Found");
        error.setMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
