/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.event;

import com.mycompany.rsvp.entity.Event;
import com.mycompany.rsvp.persistence.RsvpCrudService;
import javax.ejb.Stateless;

/**
 *
 * @author Mark
 */
@Stateless
public class EventService extends RsvpCrudService<Event, Integer> {

    public EventService() {
        super(Event.class);
    }
}
