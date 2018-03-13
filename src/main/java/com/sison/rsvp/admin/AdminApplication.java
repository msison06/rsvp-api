package com.sison.rsvp.admin;

import com.sison.rsvp.event.EventResource;
import com.sison.rsvp.guest.GuestResource;
import com.sison.rsvp.guest.InvitedGuestResource;
import com.sison.rsvp.guest.RegisteredGuestResource;
import com.sison.rsvp.registration.RegistrationResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Mark
 */
@ApplicationPath("/admin")
public class AdminApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> resources = new HashSet<>();
        resources.add(EventResource.class);
        resources.add(GuestResource.class);
        resources.add(InvitedGuestResource.class);
        resources.add(RegisteredGuestResource.class);
        resources.add(RegistrationResource.class);
        return resources;
    }
}
