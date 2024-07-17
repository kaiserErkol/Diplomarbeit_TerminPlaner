package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
public class Terminvorschlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int terminvrs_id;

    private Date datum;
    private Time uhrzeit;
    private char bestaetigt;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kostenvrs_id", nullable = false)
    private Kostenvorschlag kostenvorschlag;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @JsonIgnore
    @OneToOne(mappedBy = "terminvorschlag", cascade = CascadeType.ALL)
    private Termin termin;

    public Terminvorschlag(Date datum, Time uhrzeit, char bestaetigt, Kostenvorschlag kostenvorschlag, Kunde kunde, Termin termin) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.bestaetigt = bestaetigt;
        this.kostenvorschlag = kostenvorschlag;
        this.kunde = kunde;
        this.termin = termin;
    }

    public Terminvorschlag() {}

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(Time uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public char getBestaetigt() {
        return bestaetigt;
    }

    public void setBestaetigt(char bestaetigt) {
        this.bestaetigt = bestaetigt;
    }

    public Kostenvorschlag getKostenvorschlag() {
        return kostenvorschlag;
    }

    public void setKostenvorschlag(Kostenvorschlag kostenvorschlag) {
        this.kostenvorschlag = kostenvorschlag;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public int getTerminvrs_id() {
        return terminvrs_id;
    }

    public void setTerminvrs_id(int terminvrs_id) {
        this.terminvrs_id = terminvrs_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terminvorschlag that = (Terminvorschlag) o;
        return terminvrs_id == that.terminvrs_id && bestaetigt == that.bestaetigt && Objects.equals(datum, that.datum) && Objects.equals(uhrzeit, that.uhrzeit) && Objects.equals(kostenvorschlag, that.kostenvorschlag) && Objects.equals(kunde, that.kunde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminvrs_id, datum, uhrzeit, bestaetigt, kostenvorschlag, kunde);
    }
}
