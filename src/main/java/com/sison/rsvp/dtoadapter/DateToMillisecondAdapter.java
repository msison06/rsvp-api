package com.sison.rsvp.dtoadapter;

import java.util.Date;
import org.apache.johnzon.mapper.Adapter;

/**
 *
 * @author Mark
 */
public class DateToMillisecondAdapter implements Adapter<Date, Long> {

    @Override
    public Date to(Long b) {
        return new Date(b);
    }

    @Override
    public Long from(Date a) {
        return a.getTime();
    }
}
