package com.sison.rsvp.persistence;

import com.sison.rsvp.validation.Problem;
import com.sison.rsvp.validation.UserInputException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Generic create, retireve, update, delete, etc. for a given entity.
 *
 * @author Mark
 */
public abstract class CrudService<E, I> {

    private EntityManager em;

    //We need the class because we can't do things like E.getSimpleName()
    private final Class<E> entityClass;

    public CrudService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Get the entity class that this crud service works with
     *
     * @return
     */
    public Class<E> getEntityClass() {
        return entityClass;
    }

    /**
     * Give the ability to set an entitymanager. This is useful for injected
     * beans
     *
     * @param em
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Create an entity
     *
     * @param input
     * @return
     */
    public E create(E input) {
        em.persist(input);
        return (E) input;
    }

    /**
     * CHeck whether an entity with a given id exists or not
     *
     * @param id id of the entity
     * @return
     */
    public boolean exists(I id) {
        //Check the count. If it's 0, then it doesn't exist
        Long count = (Long) em.createQuery("select count(e) from " + entityClass.getSimpleName() + " as e where e.id = :id")
                .setParameter("id", id)
                .getSingleResult();

        if (count == 0) {
            return false;
        }

        return true;
    }

    /**
     * Retrieve a record with the given id
     *
     * @param id id of the entity
     * @return
     */
    public E get(I id) {
        E record = (E) em.find(entityClass, id);

        //In most cases, we want to avoid returning null.
        //Throw an exception here that'll just bubble up to the top
        if (record == null) {
            recordNotFoundException(id);
        }

        return record;
    }

    /**
     * Retrieve all records for this entity
     *
     * @return
     */
    public List<E> getAll() {
        return em.createQuery("select e from " + entityClass.getSimpleName() + " as e")
                .getResultList();
    }

    /**
     * Update a record.
     *
     * @param id
     * @param input
     * @return
     */
    public E update(I id, E input) {
        validateRecordExists(id);

        E updated = em.merge(input);
        return updated;
    }

    /**
     * Delete a record
     *
     * @param id
     */
    public void delete(I id) {
        validateRecordExists(id);

        em.remove(get(id));
    }

    /**
     * Validate that a record with a given id exists to operate on.
     *
     * @param id
     */
    private void validateRecordExists(I id) {
        if (id == null || !exists(id)) {
            recordNotFoundException(id);
        }
    }

    /**
     * throws a userInputException explaining that a record with the given id
     * wasn't found
     *
     * @param id
     */
    private void recordNotFoundException(I id) {
        Problem p = new Problem();
        p.setSummary("Not Found");
        p.setMessage(entityClass.getSimpleName() + " with id " + id + " was not found");
        throw new UserInputException(p);
    }
}
