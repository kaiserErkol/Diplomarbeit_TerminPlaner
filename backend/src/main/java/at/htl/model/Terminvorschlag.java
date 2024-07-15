package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Terminvorschlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int terminvrsId;

    private Date datum;
    private Date uhrzeit;
    private char bestaetigt;

    @OneToOne
    @JoinColumn(name = "kvrs_kostenvrs_id", nullable = false, unique = true)
    private Kostenvorschlag kostenvorschlag;

    @ManyToOne
    @JoinColumn(name = "k_kunde_id", nullable = false)
    private Kunde kunde;

    public Terminvorschlag(Date datum, Date uhrzeit, char bestaetigt, Kostenvorschlag kostenvorschlag, Kunde kunde) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.bestaetigt = bestaetigt;
        this.kostenvorschlag = kostenvorschlag;
        this.kunde = kunde;
    }

    public Terminvorschlag() {}

    public int getTerminvrsId() {
        return terminvrsId;
    }

    public void setTerminvrsId(int terminvrsId) {
        this.terminvrsId = terminvrsId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terminvorschlag that = (Terminvorschlag) o;
        return terminvrsId == that.terminvrsId && bestaetigt == that.bestaetigt && Objects.equals(datum, that.datum) && Objects.equals(uhrzeit, that.uhrzeit) && Objects.equals(kostenvorschlag, that.kostenvorschlag) && Objects.equals(kunde, that.kunde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminvrsId, datum, uhrzeit, bestaetigt, kostenvorschlag, kunde);
    }
}
