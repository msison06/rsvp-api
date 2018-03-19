package com.sison.rsvp.sequence;

import javax.persistence.EntityManager;
import javax.persistence.Table;

/**
 * Sqlite implementation of a sequence
 *
 * @author Mark
 */
public class SqliteSequence implements Sequence<Integer> {

    private final EntityManager em;
    private final String sequenceName;

    public SqliteSequence(EntityManager em, Class entityClass) {
        this.em = em;
        this.sequenceName = getSeqName(entityClass);
    }

    /**
     * Get the name of a sequence
     *
     * @param entityClass
     * @return
     */
    private String getSeqName(Class entityClass) {
        //We are using the Table.name annotation for the sequence name.
        //That is what it stored in the sqlite_sequence table
        Table table = (Table) entityClass.getAnnotation(Table.class);
        return table.name();
    }

    /**
     * Get the next value of this sequence an increment its value
     *
     * @return
     */
    @Override
    public Integer nextVal() {
        int currentValue = currVal();
        increment(currentValue);
        return currentValue;
    }

    /**
     * Increment the value of a sequence by 1
     *
     * @param current
     */
    private void increment(Integer current) {
        em.createNativeQuery("UPDATE sqlite_sequence SET SEQ=?1 WHERE NAME = ?2")
                .setParameter(1, current + 1)
                .setParameter(2, sequenceName)
                .executeUpdate();
    }

    /**
     * Get the current value of a sequence
     *
     * @return
     */
    @Override
    public Integer currVal() {
        return (Integer) em.createNativeQuery("SELECT SEQ FROM sqlite_sequence WHERE NAME = ?1")
                .setParameter(1, sequenceName)
                .getSingleResult();
    }
}
