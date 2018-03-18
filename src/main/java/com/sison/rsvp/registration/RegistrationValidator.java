package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.event.EventService;
import com.sison.rsvp.validation.Problem;
import com.sison.rsvp.validation.ValidationResult;
import com.sison.rsvp.validation.Validator;

/**
 * Handles validation for registrations
 *
 * @author Mark
 */
public class RegistrationValidator extends Validator<Registration> {

    private final EventService eService;

    public RegistrationValidator(EventService eService) {
        this.eService = eService;
    }

    /**
     * Validates a registration
     *
     * @param reg the registration
     * @return
     */
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

    /**
     * Check if a registration has all the required fields
     *
     * @param reg the registration
     * @return
     */
    public ValidationResult hasRequiredFields(Registration reg) {
        ValidationResult r = new ValidationResult();

        r.addProblems(checkFieldNullOrEmpty("First name", reg.getFirstName()));
        r.addProblems(checkFieldNullOrEmpty("Last name", reg.getLastName()));
        r.addProblems(checkFieldNullOrEmpty("Event", reg.getEvent()));

        if (reg.getEvent() != null) {
            //Make sure the given event object also has an id associated with it so we can tie to it.
            r.addProblems(checkFieldNullOrEmpty("Registration Event Id", reg.getEvent().getId()));
        }

        return r;
    }

    /**
     * Check if the an event exists
     *
     * @param eventId
     * @return
     */
    private boolean eventExists(Integer eventId) {
        return eService.exists(eventId);
    }

    /**
     * Create a problem representing that an event doesn't exist
     *
     * @param eventId
     * @return
     */
    private Problem eventDoesntExist(Integer eventId) {
        Problem p = new Problem();
        p.setSummary("Registration failed");
        p.setMessage("Event with id " + eventId + " does not exist.");
        return p;
    }

}
