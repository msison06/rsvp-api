/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.registration;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author Mark
 */
@Stateless
@Path("/regisration")
@RolesAllowed({"rsvpadmin"})
public class RegistrationResource {

}
