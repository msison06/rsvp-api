/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sison.rsvp.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Mark
 */
public abstract class CrudService<E, I> {

    private EntityManager em;
    private final Class<E> entityClass;

    public CrudService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public E create(E input) {
        em.persist(input);
        return (E) input;
    }

    public E get(I id) {
        E record = (E) em.find(entityClass, id);
        if (record == null) {
            throw new EntityNotFoundException(entityClass.getSimpleName() + " with id " + id + " was not found");
        }

        return record;
    }

    public List<E> getAll() {
        return em.createQuery("select e from " + entityClass.getSimpleName() + " as e")
                .getResultList();
    }

    public E update(I id, E input) {
        if (id == null) {
            throw new IllegalArgumentException("update requires id");
        }

        E updated = em.merge(input);
        return updated;
    }

    public void delete(I id) {
        em.remove(get(id));
    }
}
