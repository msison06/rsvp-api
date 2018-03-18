package com.sison.rsvp.dtoadapter;

import java.util.Date;
import org.apache.johnzon.mapper.Adapter;

/**
 * Converts json longs to java dates and vice versa
 *
 * @author Mark
 */
public class DateToMillisecondAdapter implements Adapter<Date, Long> {

    /**
     * Convert milliseconds to java date
     *
     * @param time time in milliseconds
     * @return
     */
    @Override
    public Date to(Long time) {
        return new Date(time);
    }

    /**
     * Converts java date to milliseconds
     *
     * @param time java date
     * @return
     */
    @Override
    public Long from(Date time) {
        return time.getTime();
    }
}
