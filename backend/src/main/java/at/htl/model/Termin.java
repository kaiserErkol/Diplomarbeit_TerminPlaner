package at.htl.model;

import at.htl.enums.TerminStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int terminId;

    private Date datum;
    private Date uhrzeit;
    private String notiz;

    @Enumerated(EnumType.STRING)
    private TerminStatus status;

    @OneToOne
    @JoinColumn(name = "tvrs_terminvrs_id", nullable = false, unique = true)
    private Terminvorschlag terminvorschlag;

    @OneToOne
    @JoinColumn(name = "r_reparatur_id", nullable = false, unique = true)
    private Reparatur reparatur;

    @ManyToOne
    @JoinColumn(name = "v_verwalter_id", nullable = false)
    private Verwalter verwalter;

    public Termin(Date datum, Date uhrzeit, String notiz, TerminStatus status, Terminvorschlag terminvorschlag, Reparatur reparatur, Verwalter verwalter) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.notiz = notiz;
        this.status = status;
        this.terminvorschlag = terminvorschlag;
        this.reparatur = reparatur;
        this.verwalter = verwalter;
    }

    public Termin() {}

    public int getTerminId() {
        return terminId;
    }

    public void setTerminId(int terminId) {
        this.terminId = terminId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(Date uhrzeit) {
        this.uhrzeit = uhrzeit;
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
        return terminId == termin.terminId && Objects.equals(datum, termin.datum) && Objects.equals(uhrzeit, termin.uhrzeit) && status == termin.status && Objects.equals(terminvorschlag, termin.terminvorschlag) && Objects.equals(reparatur, termin.reparatur) && Objects.equals(verwalter, termin.verwalter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminId, datum, uhrzeit, status, terminvorschlag, reparatur, verwalter);
    }
}
