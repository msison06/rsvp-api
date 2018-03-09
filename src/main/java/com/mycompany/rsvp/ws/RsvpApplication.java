package com.mycompany.rsvp.ws;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Mark
 */
@ApplicationPath("/rsvp")
public class RsvpApplication extends Application {

    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> resources = new HashSet<>();
        resources.add(RsvpResource.class);
        return resources;
    }
}
