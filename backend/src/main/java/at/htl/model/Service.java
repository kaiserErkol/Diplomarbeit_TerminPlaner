package at.htl.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Bezeichnung;

    @Column
    private String Beschreibung;

    @Column
    private Double DauerInStunden;

    @Column
    private Double Kosten;

    @Column
    private Double Serviceintervall;

    public Service(String bezeichnung, String beschreibung, Double dauerInStunden, Double kosten, Double serviceintervall) {
        Bezeichnung = bezeichnung;
        Beschreibung = beschreibung;
        DauerInStunden = dauerInStunden;
        Kosten = kosten;
        Serviceintervall = serviceintervall;
    }

    public Service() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }

    public Double getDauerInStunden() {
        return DauerInStunden;
    }

    public void setDauerInStunden(Double dauerInStunden) {
        DauerInStunden = dauerInStunden;
    }

    public Double getKosten() {
        return Kosten;
    }

    public void setKosten(Double kosten) {
        Kosten = kosten;
    }

    public Double getServiceintervall() {
        return Serviceintervall;
    }

    public void setServiceintervall(Double serviceintervall) {
        Serviceintervall = serviceintervall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id) && Objects.equals(Bezeichnung, service.Bezeichnung) && Objects.equals(Beschreibung, service.Beschreibung) && Objects.equals(DauerInStunden, service.DauerInStunden) && Objects.equals(Kosten, service.Kosten) && Objects.equals(Serviceintervall, service.Serviceintervall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Bezeichnung, Beschreibung, DauerInStunden, Kosten, Serviceintervall);
    }
}
