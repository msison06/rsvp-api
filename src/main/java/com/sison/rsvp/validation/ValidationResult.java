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
public class ValidationResult {

    private List<Problem> problems = new LinkedList<>();

    public ValidationResult() {

    }

    public ValidationResult(List<Problem> problems) {
        this.problems = new LinkedList<>(problems);
    }

    public void addProblems(ValidationResult other) {
        this.problems.addAll(other.getProblems());
    }

    public void addProblems(List<Problem> problems) {
        this.problems.addAll(problems);
    }

    public void addProblem(Problem p) {
        problems.add(p);
    }

    public boolean isValid() {
        return problems.isEmpty();
    }

    public boolean isInvalid() {
        return !isValid();
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
