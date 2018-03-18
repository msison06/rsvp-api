package com.sison.rsvp.sequence;

/**
 * Interface for sequences
 *
 * @author Mark
 */
public interface Sequence<E> {

    /**
     * Get the next value of a sequence and then increment it by 1
     *
     * @return
     */
    public E nextVal();

    /**
     * Get the current value of a sequence without incrementing
     *
     * @return
     */
    public E currVal();
}
