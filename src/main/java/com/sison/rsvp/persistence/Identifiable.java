package com.sison.rsvp.persistence;

/**
 * Interface for records with IDs. ability to get and set the id generically
 *
 * @author Mark
 */
public interface Identifiable<I> {

    /**
     * Get the primary key id for the record
     *
     * @return
     */
    public I getId();

    /**
     * Set the primary key id for the records
     *
     * @param id
     */
    public void setId(I id);
}
