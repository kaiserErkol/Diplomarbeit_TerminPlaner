package at.htl.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kundeSeq")
    @SequenceGenerator(name = "kundeSeq", sequenceName = "kunde_id_seq", allocationSize = 1)
    private int kunde_id;

    private String vorname;
    private String nachname;
    private String email;
    private String telefonnummer;
    private String adresse;


    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Benachrichtigung> benachrichtigungen;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Fahrzeug> fahrzeuge;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Termin> termine;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Kostenvorschlag> kostenvorschlaege;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TerminVorschlag> terminvorschlaege;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Verleihauto> verleihautos;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TerminAnfrage> terminanfragen;

    // Getters and Setters

    public Kunde() {
    }

    public Kunde(int kunde_id, String vorname, String nachname, String email, String telefonnummer, String adresse) {
        this.kunde_id = kunde_id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public void setKunde_id(int kunde_id) {
        this.kunde_id = kunde_id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Benachrichtigung> getBenachrichtigungen() {
        return benachrichtigungen;
    }

    public void setBenachrichtigungen(List<Benachrichtigung> benachrichtigungen) {
        this.benachrichtigungen = benachrichtigungen;
    }

    public List<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

    public void setFahrzeuge(List<Fahrzeug> fahrzeuge) {
        this.fahrzeuge = fahrzeuge;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public List<Kostenvorschlag> getKostenvorschlaege() {
        return kostenvorschlaege;
    }

    public void setKostenvorschlaege(List<Kostenvorschlag> kostenvorschlaege) {
        this.kostenvorschlaege = kostenvorschlaege;
    }

    public List<TerminVorschlag> getTerminvorschlaege() {
        return terminvorschlaege;
    }

    public void setTerminvorschlaege(List<TerminVorschlag> terminvorschlaege) {
        this.terminvorschlaege = terminvorschlaege;
    }

    public List<Verleihauto> getVerleihautos() {
        return verleihautos;
    }

    public void setVerleihautos(List<Verleihauto> verleihautos) {
        this.verleihautos = verleihautos;
    }

    public List<TerminAnfrage> getTerminanfragen() {
        return terminanfragen;
    }

    public void setTerminanfragen(List<TerminAnfrage> terminanfragen) {
        this.terminanfragen = terminanfragen;
    }
}
