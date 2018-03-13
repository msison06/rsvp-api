package com.sison.rsvp.guest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mark
 */
@Stateless
@RolesAllowed({"rsvpadmin"})
public class InvitedGuestResource {

}
