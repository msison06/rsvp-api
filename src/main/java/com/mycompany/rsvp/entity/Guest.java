package com.mycompany.rsvp.entity;

import com.mycompany.rsvp.persistence.Identifiable;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Mark
 */
@MappedSuperclass
public class Guest implements Serializable, Identifiable<Integer> {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Guest other = (Guest) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
