package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminSeq")
    @SequenceGenerator(name = "terminSeq", sequenceName = "termin_id_seq", allocationSize = 1)
    private int termin_id;

    private Date datum;
    private Date uhrzeit;
    private String status;
    private String notizen;

    @ManyToOne
    @JoinColumn(name = "service_service_id", nullable = false)
    @JsonBackReference
    private Service service;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id", nullable = false)
    @JsonBackReference
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "verwalter_verwalter_id", nullable = false)
    @JsonBackReference
    private Verwalter verwalter;

    @OneToMany(mappedBy = "termin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Mechaniker> mechaniker;

    // Getters and Setters

    public Termin() {
    }

    public Termin(int termin_id, Date datum, Date uhrzeit, String status, String notizen, Service service, Kunde kunde, Verwalter verwalter) {
        this.termin_id = termin_id;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.status = status;
        this.notizen = notizen;
        this.service = service;
        this.kunde = kunde;
        this.verwalter = verwalter;
    }

    public int getTermin_id() {
        return termin_id;
    }

    public void setTermin_id(int termin_id) {
        this.termin_id = termin_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public List<Mechaniker> getMechaniker() {
        return mechaniker;
    }

    public void setMechaniker(List<Mechaniker> mechaniker) {
        this.mechaniker = mechaniker;
    }
}
