/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.event;

import com.sison.rsvp.entity.Event;
import com.sison.rsvp.persistence.RsvpCrudService;
import javax.ejb.Stateless;

/**
 * Service layer for basic crud on the event entity
 *
 * @author Mark
 */
@Stateless
public class EventService extends RsvpCrudService<Event, Integer> {

    public EventService() {
        super(Event.class);
    }
}
