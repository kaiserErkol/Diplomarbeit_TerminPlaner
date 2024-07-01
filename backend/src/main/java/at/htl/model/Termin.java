package at.htl.model;

import at.htl.enums.TerminStatus;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Termin {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date Datum;

    @Column
    private Time Uhrzeit;

    @Column
    private TerminStatus Status;

    @Column
    private String Notizen;

    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_id", nullable = false)
    private Fahrzeug fahrzeug;

    @ManyToOne
    @JoinColumn(name = "mitarbeiter_id", nullable = false)
    private Mitarbeiter mitarbeiter;

    @ManyToMany
    @JoinTable(
            name = "termin_service",
            joinColumns = @JoinColumn(name = "termin_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;


    public Termin(Date datum, Time uhrzeit, TerminStatus status, String notizen, Kunde kunde, Fahrzeug fahrzeug, Mitarbeiter mitarbeiter) {
        Datum = datum;
        Uhrzeit = uhrzeit;
        Status = status;
        Notizen = notizen;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.mitarbeiter = mitarbeiter;
    }

    public Termin() {}

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

    public Time getUhrzeit() {
        return Uhrzeit;
    }

    public void setUhrzeit(Time uhrzeit) {
        Uhrzeit = uhrzeit;
    }

    public TerminStatus getStatus() {
        return Status;
    }

    public void setStatus(TerminStatus status) {
        Status = status;
    }

    public String getNotizen() {
        return Notizen;
    }

    public void setNotizen(String notizen) {
        Notizen = notizen;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termin termin = (Termin) o;
        return Objects.equals(id, termin.id) && Objects.equals(Datum, termin.Datum) && Objects.equals(Uhrzeit, termin.Uhrzeit) && Status == termin.Status && Objects.equals(Notizen, termin.Notizen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Datum, Uhrzeit, Status, Notizen);
    }
}
