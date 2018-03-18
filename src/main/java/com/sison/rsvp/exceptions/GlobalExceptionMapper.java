/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.exceptions;

import com.sison.rsvp.validation.Problem;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Top layer exception handling for any kind of exception to reduce handling any
 * other uncaught ones in the code. If there exists a more specific
 * ExceptionMapper for an exception, then that will be chosen instead.
 *
 * @author Mark
 */
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception e) {
        //Hide the internal implementation (server, code, etc.) from the user
        Problem error = new Problem();
        error.setMessage("Oops! Something went wrong!");
        error.setMessage("Internal Server Error: Contact Administrator");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
