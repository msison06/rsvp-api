package com.sison.rsvp.validation;

import java.io.Serializable;

/**
 * Represents a problem that we can return as human readable error messaging
 *
 * @author Mark
 */
public class Problem implements Serializable {

    /**
     * Summary of the problem
     */
    private String summary;

    /**
     * more detailed problem description
     */
    private String message;

    /**
     * Get the summary of the problem
     *
     * @return
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Set the summary
     *
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Get a more detailed description of the problem
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * set the message
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
