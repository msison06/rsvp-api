/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.validation;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mark
 */
public class UserInputException extends RuntimeException {

    List<Problem> problems = new LinkedList<>();

    public UserInputException(Problem problem) {
        problems.add(problem);
    }

    public UserInputException(List<Problem> problems) {
        this.problems = problems;
    }

    public UserInputException(ValidationResult r) {
        this.problems = r.getProblems();
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
