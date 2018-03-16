/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.event.EventService;
import com.sison.rsvp.validation.Problem;
import com.sison.rsvp.validation.ValidationResult;
import com.sison.rsvp.validation.Validator;

/**
 *
 * @author Mark
 */
public class RegistrationValidator extends Validator<Registration> {

    private final EventService eService;

    public RegistrationValidator(EventService eService) {
        this.eService = eService;
    }

    @Override
    public ValidationResult validate(Registration reg) {
        ValidationResult result;

        //Check if it has all required fields
        result = hasRequiredFields(reg);
        if (result.isInvalid()) {
            //Don't proceed if we're missing stuff so we don't NPE
            return result;
        }

        //All required fields, check event exists
        Integer eventId = reg.getEvent().getId();
        if (!eventExists(eventId)) {
            result.addProblem(eventDoesntExist(eventId));
        }
        return result;
    }

    public ValidationResult hasRequiredFields(Registration reg) {
        ValidationResult r = new ValidationResult();

        r.addProblems(checkFieldNullOrEmpty("First name", reg.getFirstName()));
        r.addProblems(checkFieldNullOrEmpty("Last name", reg.getLastName()));
        r.addProblems(checkFieldNullOrEmpty("Event", reg.getEvent()));

        if (reg.getEvent() != null) {
            r.addProblems(checkFieldNullOrEmpty("Registration Event Id", reg.getEvent().getId()));
        }

        return r;
    }

    private boolean eventExists(Integer eventId) {
        return eService.exists(eventId);
    }

    private Problem eventDoesntExist(Integer eventId) {
        Problem p = new Problem();
        p.setSummary("Registration failed");
        p.setMessage("Event with id " + eventId + " does not exist.");
        return p;
    }

}
