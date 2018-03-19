package com.sison.rsvp.validation;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.ApplicationException;

/**
 * Exception for user input
 *
 * @author Mark
 */
public class UserInputException extends RuntimeException {

    List<Problem> problems = new LinkedList<>();

    /**
     * Add a problem
     *
     * @param problem
     */
    public UserInputException(Problem problem) {
        problems.add(problem);
    }

    /**
     * Add problems
     *
     * @param problems
     */
    public UserInputException(List<Problem> problems) {
        this.problems = problems;
    }

    /**
     * Add problems from a validation result
     *
     * @param r
     */
    public UserInputException(ValidationResult r) {
        this.problems = r.getProblems();
    }

    /**
     * retrieve the problems that caused the user input exception
     *
     * @return
     */
    public List<Problem> getProblems() {
        return problems;
    }
}
