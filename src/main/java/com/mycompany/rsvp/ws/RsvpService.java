package com.mycompany.rsvp.ws;

import com.mycompany.rsvp.entity.Event;
import com.mycompany.rsvp.entity.RegisteredGuest;
import com.mycompany.rsvp.entity.Registration;
import com.mycompany.rsvp.event.EventService;
import com.mycompany.rsvp.registeredguest.RegisteredGuestService;
import com.mycompany.rsvp.registration.RegistrationService;
import java.time.LocalDateTime;
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
    protected RegisteredGuestService rguestService;

    public Event eventInfo(Integer id) {
        Event event = eventService.get(id);

        return event;
    }

    public Registration register(Registration registration) {
        //set registration time to incoming

        registration.setDate(new Date());

        System.out.println("DATE: " + registration.getDate());

        //Create guest entry
        RegisteredGuest guest = rguestService.create(registration.getGuestInfo());

        //Hook up to event
        Event event = eventService.get(registration.getEvent().getId());
        registration.setEvent(event);
        registration.setGuestInfo(guest);

        //Create registration and set relationship to guest info
        registration = regService.create(registration);
        guest.setRegistration(registration);

        return registration;
    }
}
