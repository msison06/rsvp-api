package com.mycompany.rsvp.sequence.sqlite;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import com.mycompany.rsvp.sequence.Sequence;

/**
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

    private String getSeqName(Class entityClass) {
        Table table = (Table) entityClass.getAnnotation(Table.class);
        return table.name();
    }

    @Override
    public Integer nextVal() {
        increment(currVal());
        return currVal();
    }

    private void increment(Integer current) {
        em.createNativeQuery("UPDATE sqlite_sequence SET SEQ=?1 WHERE NAME = ?2")
                .setParameter(1, current + 1)
                .setParameter(2, sequenceName)
                .executeUpdate();
    }

    @Override
    public Integer currVal() {
        return (Integer) em.createNativeQuery("SELECT SEQ FROM sqlite_sequence WHERE NAME = ?1")
                .setParameter(1, sequenceName)
                .getSingleResult();
    }
}
