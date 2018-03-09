package com.sison.rsvp.registration;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.entity.Registration;
import com.sison.rsvp.event.EventService;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Mark
 */
public class RegistrationValidationTests {

    private RegistrationValidator validator;
    private EventService eventService;

    @Before
    public void init() {
        eventService = mock(EventService.class);
        validator = new RegistrationValidator(eventService);
    }

    @Test
    public void shouldBeValidWithGoodInput() {
        Registration r = createGoodRegistration();
        Integer eventId = r.getEvent().getId();
        when(eventService.exists(eventId)).thenReturn(Boolean.TRUE);

        Assert.assertTrue(validator.validate(r).isValid());
    }

    @Test
    public void shouldCheckEventExists() {
        Registration r = createGoodRegistration();
        Integer eventId = r.getEvent().getId();
        when(eventService.exists(eventId)).thenReturn(Boolean.FALSE);

        Assert.assertTrue(validator.validate(r).isInvalid());
    }

    @Test
    public void shouldRequireEvent() {
        Registration r = createGoodRegistration();
        r.setEvent(null);

        Assert.assertTrue(validator.validate(r).isInvalid());
    }

    @Test
    public void shouldRequireEventId() {
        Registration r = createGoodRegistration();
        r.getEvent().setId(null);

        Assert.assertTrue(validator.validate(r).isInvalid());
    }

    @Test
    public void shouldRequireFirstName() {
        Registration r = createGoodRegistration();
        r.setFirstName(null);

        Assert.assertTrue(validator.validate(r).isInvalid());
    }

    @Test
    public void shouldRequireLastName() {
        Registration r = createGoodRegistration();
        r.setLastName(null);

        Assert.assertTrue(validator.validate(r).isInvalid());
    }

    /**
     * Helper function that gives a good registration so that we can break it in
     * the tests
     *
     * @return
     */
    private Registration createGoodRegistration() {
        Registration r = new Registration();
        r.setId(1);
        r.setFirstName("firstname");
        r.setLastName("lastname");
        r.setDate(new Date());
        r.setAdditionalGuests(4);

        Event e = new Event();
        e.setId(1);
        r.setEvent(e);

        return r;
    }
}
