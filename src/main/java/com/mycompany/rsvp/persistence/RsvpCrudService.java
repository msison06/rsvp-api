package com.mycompany.rsvp.persistence;

import com.mycompany.rsvp.sequence.Sequence;
import com.mycompany.rsvp.sequence.SequenceService;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class RsvpCrudService<E extends Identifiable, I> extends CrudService<E, I> {

    @PersistenceContext(unitName = "rsvp_pu")
    protected EntityManager em;

    @Inject
    private SequenceService sequenceService;

    private Sequence<Integer> sequence;

    public RsvpCrudService(Class<E> entityClass) {
        super(entityClass);
    }

    @PostConstruct
    public void postConstruct() {
        this.setEntityManager(em);
        this.sequence = sequenceService.getSequence(getEntityClass());
    }

    protected Sequence<Integer> getSequence() {
        return sequence;
    }

    protected void setSequence(Sequence<Integer> sequence) {
        this.sequence = sequence;
    }

    @Override
    public E create(E input) {
        //Get real id
        input.setId(sequence.nextVal());

        return super.create(input);
    }
}
