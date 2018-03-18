package com.sison.rsvp.persistence;

import com.sison.rsvp.sequence.Sequence;
import com.sison.rsvp.sequence.SequenceService;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract class for crud services in the rsvp persistence context. Subclasses
 * will inherit the annotations and be given a sequence to work with.
 *
 * @author Mark
 * @param <E> Entity class
 * @param <I> Id type of class
 */
public abstract class RsvpCrudService<E extends Identifiable, I> extends CrudService<E, I> {

    @PersistenceContext(unitName = "rsvp_pu")
    protected EntityManager em;

    /**
     * We user the sequence service to give up the next value to use for our ids
     * on create
     */
    @Inject
    private SequenceService sequenceService;

    private Sequence<Integer> sequence;

    public RsvpCrudService(Class<E> entityClass) {
        super(entityClass);
    }

    @PostConstruct
    public void postConstruct() {
        //set the entity manager after it's been injected
        this.setEntityManager(em);

        //retrieve the sequence from the sequence service once its been injected too
        this.sequence = sequenceService.getSequence(getEntityClass());
    }

    /**
     * Retreive the sequence we'll work with
     *
     * @return
     */
    protected Sequence<Integer> getSequence() {
        return sequence;
    }

    /**
     * Set the sequence we'll work with. We can possibly remove this function if
     * it's not needed later on
     *
     * @param sequence
     */
    protected void setSequence(Sequence<Integer> sequence) {
        this.sequence = sequence;
    }

    /**
     * Create an entity while using the sequence to get its value
     *
     * @param input
     * @return
     */
    @Override
    public E create(E input) {
        //Get real id
        input.setId(sequence.nextVal());

        return super.create(input);
    }
}
