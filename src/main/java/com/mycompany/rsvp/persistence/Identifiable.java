/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rsvp.persistence;

/**
 *
 * @author Mark
 */
public interface Identifiable<I> {

    public I getId();

    public void setId(I id);
}
