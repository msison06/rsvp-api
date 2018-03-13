/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.admin;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Mark
 */
@Stateless
@RolesAllowed({"rsvpadmin"})
public class RegisteredGuestResource {

}
