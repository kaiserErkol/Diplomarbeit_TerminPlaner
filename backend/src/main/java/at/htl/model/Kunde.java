package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kunde_id;

    private String vorname;
    private String nachname;
    private String email;
    private String telefonnummer;
    private String postleitzahl;
    private String ort;
    private String adresse;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reparatur> reparaturList;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Fahrzeug> fahrzeugList;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Terminvorschlag> terminvorschlagList;

    @JsonIgnore
    @OneToOne(mappedBy = "kunde", cascade = CascadeType.ALL)
    private Leihvertrag leihvertrag;

    public Kunde(String vorname, String nachname, String email, String telefonnummer, String postleitzahl, String ort, String adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
        this.adresse = adresse;
    }

    public Kunde(String vorname, String nachname, String email, String telefonnummer, String postleitzahl, String ort, String adresse, Leihvertrag leihvertrag) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
        this.adresse = adresse;
        this.leihvertrag = leihvertrag;
    }

    public Kunde() {
        fahrzeugList = new LinkedList<>();
        reparaturList = new LinkedList<>();
    }

    public List<Terminvorschlag> getTerminvorschlagList() {
        return terminvorschlagList;
    }

    public void setTerminvorschlagList(List<Terminvorschlag> terminvorschlagList) {
        this.terminvorschlagList = terminvorschlagList;
    }

    public int getKundeId() {
        return kunde_id;
    }

    public void setKundeId(int kundeId) {
        this.kunde_id = kundeId;
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

    public List<Reparatur> getReparaturList() {
        return reparaturList;
    }

    public void setReparaturList(List<Reparatur> reparaturList) {
        this.reparaturList = reparaturList;
    }

    public List<Fahrzeug> getFahrzeugList() {
        return fahrzeugList;
    }

    public void setFahrzeugList(List<Fahrzeug> fahrzeugList) {
        this.fahrzeugList = fahrzeugList;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public void setKunde_id(int kunde_id) {
        this.kunde_id = kunde_id;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Leihvertrag getLeihvertrag() {
        return leihvertrag;
    }

    public void setLeihvertrag(Leihvertrag leihvertrag) {
        this.leihvertrag = leihvertrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kunde kunde = (Kunde) o;
        return kunde_id == kunde.kunde_id && Objects.equals(vorname, kunde.vorname) && Objects.equals(nachname, kunde.nachname) && Objects.equals(email, kunde.email) && Objects.equals(telefonnummer, kunde.telefonnummer) && Objects.equals(postleitzahl, kunde.postleitzahl) && Objects.equals(ort, kunde.ort) && Objects.equals(adresse, kunde.adresse) && Objects.equals(fahrzeugList, kunde.fahrzeugList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kunde_id, vorname, nachname, email, telefonnummer, postleitzahl, ort, adresse, fahrzeugList);
    }
}
