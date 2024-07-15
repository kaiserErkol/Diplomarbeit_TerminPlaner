package at.htl.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
class TerminMechanikerId implements Serializable {
    private int terminId;
    private int mechanikerId;

    public TerminMechanikerId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminMechanikerId that = (TerminMechanikerId) o;
        return terminId == that.terminId && mechanikerId == that.mechanikerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminId, mechanikerId);
    }
}
