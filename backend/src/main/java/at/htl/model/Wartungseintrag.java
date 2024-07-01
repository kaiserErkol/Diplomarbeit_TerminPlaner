package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Wartungseintrag {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date Datum;

    @Column
    private String Beschreibung;

    @Column
    private Double Kosten;

    @Column
    private Date NaechsterServiceDatum;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_id", nullable = false)
    private Fahrzeug fahrzeug;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    public Wartungseintrag(Date datum, String beschreibung, Double kosten, Date naechsterServiceDatum, Fahrzeug fahrzeug, Service service) {
        Datum = datum;
        Beschreibung = beschreibung;
        Kosten = kosten;
        NaechsterServiceDatum = naechsterServiceDatum;
        this.fahrzeug = fahrzeug;
        this.service = service;
    }

    public Wartungseintrag() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }

    public Double getKosten() {
        return Kosten;
    }

    public void setKosten(Double kosten) {
        Kosten = kosten;
    }

    public Date getNaechsterServiceDatum() {
        return NaechsterServiceDatum;
    }

    public void setNaechsterServiceDatum(Date naechsterServiceDatum) {
        NaechsterServiceDatum = naechsterServiceDatum;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wartungseintrag that = (Wartungseintrag) o;
        return Objects.equals(id, that.id) && Objects.equals(Datum, that.Datum) && Objects.equals(Beschreibung, that.Beschreibung) && Objects.equals(Kosten, that.Kosten) && Objects.equals(NaechsterServiceDatum, that.NaechsterServiceDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Datum, Beschreibung, Kosten, NaechsterServiceDatum);
    }
}
