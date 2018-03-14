package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.event.EventService;
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

    public Event eventInfo(Integer id) {
        Event event = eventService.get(id);

        return event;
    }

    public Registration register(Registration registration) {
        //set registration time to incoming

        registration.setDate(new Date());

        System.out.println("DATE: " + registration.getDate());

        //Hook up to event
        Event event = eventService.get(registration.getEvent().getId());
        registration.setEvent(event);

        //Create registration and set relationship to guest info
        registration = regService.create(registration);

        return registration;
    }
}
