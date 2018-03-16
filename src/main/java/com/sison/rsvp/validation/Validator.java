/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.validation;

/**
 *
 * @author Mark
 */
public abstract class Validator<E> {

    public abstract ValidationResult validate(E e);

    public ValidationResult checkFieldNullOrEmpty(String fieldName, Object value) {
        ValidationResult result = new ValidationResult();
        if (value == null) {
            result.addProblem(missing(fieldName));
        }

        return result;
    }

    private Problem missing(String fieldName) {
        Problem p = new Problem();
        p.setSummary("Missing required input");
        p.setMessage(fieldName + " is required.");
        return p;
    }
}
