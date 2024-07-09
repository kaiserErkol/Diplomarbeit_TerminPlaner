package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Wartungsverlauf {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wartungsverlaufSeq")
    @SequenceGenerator(name = "wartungsverlaufSeq", sequenceName = "wartungsverlauf_id_seq", allocationSize = 1)
    private int wartungsverlauf_id;

    private Date datum;
    private String status;
    private String notiz;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_fahrzeug_id", nullable = false)
    @JsonBackReference
    private Fahrzeug fahrzeug;

    @ManyToOne
    @JoinColumn(name = "service_service_id", nullable = false)
    @JsonBackReference
    private Service service;

    @ManyToOne
    @JoinColumn(name = "mechaniker_mechaniker_id", nullable = false)
    @JsonBackReference
    private Mechaniker mechaniker;

    // Getters and Setters


    public Wartungsverlauf() {
    }

    public Wartungsverlauf(Date datum, String status, String notiz, Fahrzeug fahrzeug, Service service, Mechaniker mechaniker) {
        this.datum = datum;
        this.status = status;
        this.notiz = notiz;
        this.fahrzeug = fahrzeug;
        this.service = service;
        this.mechaniker = mechaniker;
    }

    public int getWartungsverlauf_id() {
        return wartungsverlauf_id;
    }

    public void setWartungsverlauf_id(int wartungsverlauf_id) {
        this.wartungsverlauf_id = wartungsverlauf_id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
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

    public Mechaniker getMechaniker() {
        return mechaniker;
    }

    public void setMechaniker(Mechaniker mechaniker) {
        this.mechaniker = mechaniker;
    }
}
