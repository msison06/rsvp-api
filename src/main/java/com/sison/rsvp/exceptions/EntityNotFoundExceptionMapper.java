/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.exceptions;

import com.sison.rsvp.validation.Problem;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Mark
 */
@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(EntityNotFoundException e) {
        Problem error = new Problem();
        error.setSummary("Not Found");
        error.setMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
