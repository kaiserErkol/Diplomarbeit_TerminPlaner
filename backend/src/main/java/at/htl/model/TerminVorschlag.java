package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class TerminVorschlag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminvorschlagSeq")
    @SequenceGenerator(name = "terminvorschlagSeq", sequenceName = "terminvorschlag_id_seq", allocationSize = 1)
    private int terminvorschlag_id;

    private Date datum;
    private Date uhrzeit;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id", nullable = false)
    @JsonBackReference
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "verwalter_verwalter_id", nullable = false)
    @JsonBackReference
    private Verwalter verwalter;

    // Getters and Setters

    public TerminVorschlag() {
    }

    public TerminVorschlag(Date datum, Time uhrzeit, Kunde kunde, Verwalter verwalter) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kunde = kunde;
        this.verwalter = verwalter;
    }

    public int getTerminvorschlag_id() {
        return terminvorschlag_id;
    }

    public void setTerminvorschlag_id(int terminvorschlag_id) {
        this.terminvorschlag_id = terminvorschlag_id;
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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Verwalter getVerwalter() {
        return verwalter;
    }

    public void setVerwalter(Verwalter verwalter) {
        this.verwalter = verwalter;
    }
}
