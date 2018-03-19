package com.sison.rsvp.validation;

import java.util.LinkedList;
import java.util.List;

/**
 * The result of validation
 *
 * @author Mark
 */
public class ValidationResult {

    private List<Problem> problems = new LinkedList<>();

    public ValidationResult() {

    }

    /**
     * Create a validation result given a list of problems
     *
     * @param problems
     */
    public ValidationResult(List<Problem> problems) {
        this.problems = new LinkedList<>(problems);
    }

    /**
     * Add the problems from another validation result
     *
     * @param other
     */
    public void addProblems(ValidationResult other) {
        this.problems.addAll(other.getProblems());
    }

    /**
     * Adds a list of problems
     *
     * @param problems
     */
    public void addProblems(List<Problem> problems) {
        this.problems.addAll(problems);
    }

    /**
     * Adds a problem
     *
     * @param p
     */
    public void addProblem(Problem p) {
        problems.add(p);
    }

    /**
     * Check if this result is valid or not.
     *
     * @return
     */
    public boolean isValid() {
        return problems.isEmpty();
    }

    /**
     * Check if this result is invalid or not
     *
     * @return
     */
    public boolean isInvalid() {
        return !isValid();
    }

    /**
     * Get a list of problems with the validation result
     *
     * @return
     */
    public List<Problem> getProblems() {
        return problems;
    }
}
