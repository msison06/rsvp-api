package com.sison.rsvp.validation;

/**
 * Abstract class for a validator
 *
 * @author Mark
 */
public abstract class Validator<E> {

    /**
     * Validate a given entity
     *
     * @param e entity to validate
     * @return
     */
    public abstract ValidationResult validate(E e);

    /**
     * Check if a field is null
     *
     * @param fieldName
     * @param value
     * @return
     */
    public ValidationResult checkFieldNullOrEmpty(String fieldName, Object value) {
        ValidationResult result = new ValidationResult();

        //Value is null, add the problem
        if (value == null) {
            result.addProblem(missing(fieldName));
        }

        return result;
    }

    /**
     * Create a problem representing a missing field
     *
     * @param fieldName
     * @return
     */
    private Problem missing(String fieldName) {
        Problem p = new Problem();
        p.setSummary("Missing required input");
        p.setMessage(fieldName + " is required.");
        return p;
    }
}
