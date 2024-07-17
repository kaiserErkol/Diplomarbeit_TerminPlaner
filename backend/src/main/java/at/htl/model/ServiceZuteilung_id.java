package at.htl.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServiceZuteilung_id implements Serializable {

    @ManyToOne
    @JoinColumn(name = "retyp_id")
    private Reparaturtyp reparaturtyp;

    @ManyToOne
    @JoinColumn(name = "reparatur_id")
    private Reparatur reparatur;

    public ServiceZuteilung_id(Reparaturtyp reparaturtyp, Reparatur reparatur) {
        this.reparaturtyp = reparaturtyp;
        this.reparatur = reparatur;
    }

    public ServiceZuteilung_id() {}

    public Reparaturtyp getReparaturtyp() {
        return reparaturtyp;
    }

    public void setReparaturtyp(Reparaturtyp reparaturtyp) {
        this.reparaturtyp = reparaturtyp;
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
        ServiceZuteilung_id that = (ServiceZuteilung_id) o;
        return Objects.equals(reparaturtyp, that.reparaturtyp) && Objects.equals(reparatur, that.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reparaturtyp, reparatur);
    }
}
