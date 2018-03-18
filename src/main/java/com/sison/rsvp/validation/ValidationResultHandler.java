package com.sison.rsvp.validation;

import javax.ejb.Stateless;

/**
 * Handles a validation result.
 *
 * @author Mark
 */
@Stateless
public class ValidationResultHandler {

    /**
     * Throws a userinput exception if the validation result is invalid
     *
     * @param r
     */
    public void handleResult(ValidationResult r) {
        if (r.isInvalid()) {
            throw new UserInputException(r);
        }
    }
}
