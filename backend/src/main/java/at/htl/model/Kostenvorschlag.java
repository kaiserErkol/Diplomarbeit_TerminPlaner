package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Kostenvorschlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kostenvrsId;

    private Date datum;
    private double kosten;
    private String beschreibung;

    @OneToOne
    @JoinColumn(name = "r_reparatur_id", nullable = false, unique = true)
    private Reparatur reparatur;

    public Kostenvorschlag(Date datum, double kosten, String beschreibung, Reparatur reparatur) {
        this.datum = datum;
        this.kosten = kosten;
        this.beschreibung = beschreibung;
        this.reparatur = reparatur;
    }

    public Kostenvorschlag() {}

    public int getKostenvrsId() {
        return kostenvrsId;
    }

    public void setKostenvrsId(int kostenvrsId) {
        this.kostenvrsId = kostenvrsId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
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
        Kostenvorschlag that = (Kostenvorschlag) o;
        return kostenvrsId == that.kostenvrsId && Double.compare(kosten, that.kosten) == 0 && Objects.equals(datum, that.datum) && Objects.equals(beschreibung, that.beschreibung) && Objects.equals(reparatur, that.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kostenvrsId, datum, kosten, beschreibung, reparatur);
    }
}

