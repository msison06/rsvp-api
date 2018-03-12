/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.sequence;

/**
 *
 * @author Mark
 */
public interface Sequence<E> {

    public E nextVal();

    public E currVal();
}
