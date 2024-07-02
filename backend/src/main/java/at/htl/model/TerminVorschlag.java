package at.htl.model;

import at.htl.enums.TerminStatus;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class TerminVorschlag {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date Datum;

    @Column
    private Time Uhrzeit;

    @Column
    private String Notizen;

    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "mitarbeiter_id", nullable = false)
    private Mitarbeiter mitarbeiter;

    @ManyToMany
    @JoinTable(
            name = "terminv_service",
            joinColumns = @JoinColumn(name = "terminv_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

    public TerminVorschlag(Long id, Date datum, Time uhrzeit, String notizen, Kunde kunde, Mitarbeiter mitarbeiter) {
        this.id = id;
        Datum = datum;
        Uhrzeit = uhrzeit;
        Notizen = notizen;
        this.kunde = kunde;
        this.mitarbeiter = mitarbeiter;
    }

    public TerminVorschlag() {}

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
}
