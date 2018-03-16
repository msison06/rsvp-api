package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.event.EventService;
import com.sison.rsvp.validation.ValidationResultHandler;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
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

    public Event eventInfo(Integer id) {
        Event event = eventService.get(id);

        return event;
    }

    public Registration register(Registration registration) {
        //set registration time to incomings
        registration.setDate(new Date());

        //Validate user input
        validate(registration);

        //Hook up registration to event
        Event event = eventService.get(registration.getEvent().getId());
        registration.setEvent(event);

        //Create registration and set relationship to guest info
        registration = regService.create(registration);

        return registration;
    }

    private void validate(Registration r) {
        RegistrationValidator validator = new RegistrationValidator(eventService);
        resultHandler.handleResult(validator.validate(r));
    }
}
