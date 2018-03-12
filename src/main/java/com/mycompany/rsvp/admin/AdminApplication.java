package com.mycompany.rsvp.admin;

import com.mycompany.rsvp.event.EventResource;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Mark
 */
@ApplicationPath("/admin")
@RolesAllowed({"rsvpadmin"})
public class AdminApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> resources = new HashSet<>();
        resources.add(EventResource.class);
        return resources;
    }
}
