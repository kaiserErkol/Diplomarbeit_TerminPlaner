package at.htl.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
class TerminMechanikerId implements Serializable {
    private int termin_id;
    private int mechaniker_id;

    public TerminMechanikerId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminMechanikerId that = (TerminMechanikerId) o;
        return termin_id == that.termin_id && mechaniker_id == that.mechaniker_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(termin_id, mechaniker_id);
    }
}
