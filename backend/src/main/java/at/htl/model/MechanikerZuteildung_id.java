package at.htl.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MechanikerZuteildung_id implements Serializable{

    @ManyToOne
    @JoinColumn(name = "mechaniker_id")
    private Mechaniker mechaniker;

    @ManyToOne
    @JoinColumn(name = "reparatur_id")
    private Reparatur reparatur;

    public MechanikerZuteildung_id(Mechaniker mechaniker, Reparatur reparatur) {
        this.mechaniker = mechaniker;
        this.reparatur = reparatur;
    }

    public MechanikerZuteildung_id() {}

    public Mechaniker getMechaniker() {
        return mechaniker;
    }

    public void setMechaniker(Mechaniker mechaniker) {
        this.mechaniker = mechaniker;
    }

    public Reparatur getReparatur() {
        return reparatur;
    }

    public void setReparatur(Reparatur reparatur) {
        this.reparatur = reparatur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MechanikerZuteildung_id that = (MechanikerZuteildung_id) o;
        return Objects.equals(mechaniker, that.mechaniker) && Objects.equals(reparatur, that.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mechaniker, reparatur);
    }
}
