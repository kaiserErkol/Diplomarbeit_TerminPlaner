package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Kostenvorschlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kostenvrs_id;

    private Date datum;
    private double kosten;
    private String beschreibung;
    private char bestaetigt;

    @JsonIgnore
    @OneToOne (mappedBy = "kostenvorschlag", cascade = CascadeType.ALL)
    private Reparatur reparatur;

    @OneToMany (mappedBy = "kostenvorschlag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Terminvorschlag> terminvorschlagList = new LinkedList<>();

    public Kostenvorschlag(Date datum, double kosten, String beschreibung, char bestaetigt, Reparatur reparatur) {
        this.datum = datum;
        this.kosten = kosten;
        this.beschreibung = beschreibung;
        this.bestaetigt = bestaetigt;
        this.reparatur = reparatur;
    }

    public Kostenvorschlag() {}

    public int getKostenvrs_id() {
        return kostenvrs_id;
    }

    public void setKostenvrs_id(int kostenvrs_id) {
        this.kostenvrs_id = kostenvrs_id;
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

    public char getBestaetigt() {
        return bestaetigt;
    }

    public void setBestaetigt(char bestaetigt) {
        this.bestaetigt = bestaetigt;
    }

    public List<Terminvorschlag> getTerminvorschlagList() {
        return terminvorschlagList;
    }

    public void setTerminvorschlagList(List<Terminvorschlag> terminvorschlagList) {
        this.terminvorschlagList = terminvorschlagList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kostenvorschlag that = (Kostenvorschlag) o;
        return kostenvrs_id == that.kostenvrs_id && Double.compare(kosten, that.kosten) == 0 && Objects.equals(datum, that.datum) && Objects.equals(beschreibung, that.beschreibung) && Objects.equals(reparatur, that.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kostenvrs_id, datum, kosten, beschreibung, reparatur);
    }
}

