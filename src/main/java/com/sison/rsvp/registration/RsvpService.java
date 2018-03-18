package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.event.EventService;
import com.sison.rsvp.validation.ValidationResultHandler;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Service layer for rsvp services
 *
 * @author Mark
 */
@Stateless
public class RsvpService {

    @Inject
    protected EventService eventService;

    @Inject
    protected RegistrationService regService;

    @Inject
    protected ValidationResultHandler resultHandler;

    /**
     * Get the event given an id
     *
     * @param id id of the event
     * @return
     */
    public Event eventInfo(Integer id) {
        Event event = eventService.get(id);

        return event;
    }

    /**
     * Add a registration
     *
     * @param registration
     * @return
     */
    public Registration register(Registration registration) {
        //set registration time to incomings
        registration.setDate(new Date());

        //Validate user input
        validate(registration);

        //Hook up registration to event
        Event event = eventService.get(registration.getEvent().getId());
        registration.setEvent(event);

        //Create registration
        registration = regService.create(registration);

        return registration;
    }

    /**
     * Validate a registration
     *
     * @param r registration to validate
     */
    private void validate(Registration r) {
        RegistrationValidator validator = new RegistrationValidator(eventService);
        resultHandler.handleResult(validator.validate(r));
    }
}
