package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;


@Entity
public class TerminAnfrage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminanfrageSeq")
    @SequenceGenerator(name = "terminanfrageSeq", sequenceName = "terminanfrage_id_seq", allocationSize = 1)
    private int terminanfrage_id;

    private Date datum;
    private String notiz;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id", nullable = false)
    @JsonBackReference
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_fahrzeug_id", nullable = false)
    @JsonBackReference
    private Fahrzeug fahrzeug;

    @ManyToOne
    @JoinColumn(name = "verwalter_verwalter_id", nullable = false)
    @JsonBackReference
    private Verwalter verwalter;

    @ManyToOne
    @JoinColumn(name = "service_service_id", nullable = false)
    @JsonBackReference
    private Service service;

    public TerminAnfrage() {

    }

    public TerminAnfrage(int terminanfrage_id, Date datum, String notiz, Kunde kunde, Fahrzeug fahrzeug, Verwalter verwalter, Service service) {
        this.terminanfrage_id = terminanfrage_id;
        this.datum = datum;
        this.notiz = notiz;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.verwalter = verwalter;
        this.service = service;
    }

    public int getTerminanfrage_id() {
        return terminanfrage_id;
    }

    public void setTerminanfrage_id(int terminanfrage_id) {
        this.terminanfrage_id = terminanfrage_id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
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

    public Verwalter getVerwalter() {
        return verwalter;
    }

    public void setVerwalter(Verwalter verwalter) {
        this.verwalter = verwalter;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
