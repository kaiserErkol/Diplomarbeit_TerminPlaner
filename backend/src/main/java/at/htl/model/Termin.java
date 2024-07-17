package at.htl.model;

import at.htl.enums.Arbeitstagen;
import at.htl.enums.TerminStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int termin_id;

    private String notiz;

    @Enumerated(EnumType.STRING)
    private TerminStatus status;

    @OneToOne
    @JoinColumn(name = "terminvrs_id", referencedColumnName = "terminvrs_id")
    private Terminvorschlag terminvorschlag;

    @JsonIgnore
    @OneToOne(mappedBy = "termin", cascade = CascadeType.ALL)
    private Reparatur reparatur;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verwalter_id", nullable = false)
    private Verwalter verwalter;

    /**
     * #TODO
     * Implement ManyToMany Relation to Mechaniker
     */

    public Termin(String notiz, TerminStatus status, Terminvorschlag terminvorschlag, Reparatur reparatur, Verwalter verwalter) {
        this.notiz = notiz;
        this.status = status;
        this.terminvorschlag = terminvorschlag;
        this.reparatur = reparatur;
        this.verwalter = verwalter;
    }

    public Termin() {
    }

    public int getTermin_id() {
        return termin_id;
    }

    public void setTermin_id(int termin_id) {
        this.termin_id = termin_id;
    }

    public Terminvorschlag getTerminvorschlag() {
        return terminvorschlag;
    }

    public void setTerminvorschlag(Terminvorschlag terminvorschlag) {
        this.terminvorschlag = terminvorschlag;
    }

    public Reparatur getReparatur() {
        return reparatur;
    }

    public void setReparatur(Reparatur reparatur) {
        this.reparatur = reparatur;
    }

    public Verwalter getVerwalter() {
        return verwalter;
    }

    public void setVerwalter(Verwalter verwalter) {
        this.verwalter = verwalter;
    }

    public TerminStatus getStatus() {
        return status;
    }

    public void setStatus(TerminStatus status) {
        this.status = status;
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termin termin = (Termin) o;
        return termin_id == termin.termin_id && status == termin.status && Objects.equals(terminvorschlag, termin.terminvorschlag) && Objects.equals(reparatur, termin.reparatur) && Objects.equals(verwalter, termin.verwalter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(termin_id,status, terminvorschlag, reparatur, verwalter);
    }
}
