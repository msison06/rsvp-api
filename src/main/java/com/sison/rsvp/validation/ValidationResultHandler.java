/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.validation;

import javax.ejb.Stateless;

/**
 *
 * @author Mark
 */
@Stateless
public class ValidationResultHandler {

    public void handleResult(ValidationResult r) {
        if (r.isInvalid()) {
            throw new UserInputException(r);
        }
    }
}
