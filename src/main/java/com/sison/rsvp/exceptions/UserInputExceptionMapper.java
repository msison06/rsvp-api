/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.exceptions;

import com.sison.rsvp.validation.UserInputException;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Top layer exception handling for UserInputException to reduce handling them
 * in code.
 *
 * @author Mark
 */
@Provider
public class UserInputExceptionMapper implements ExceptionMapper<UserInputException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(UserInputException e) {
        //Send back the list of problems for the frontend guys. This will most
        //likely be useful for user input on forms
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getProblems()).build();
    }
}
