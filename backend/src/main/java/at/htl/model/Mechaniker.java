package at.htl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Mechaniker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mechaniker_id;

    private String namekrzl;
    private String vorname;
    private String nachname;
    private String telefonnummer;
    private String email;
    private String postleitzahl;
    private String ort;
    private String adresse;

    public Mechaniker(String namekrzl, String vorname, String nachname, String telefonnummer, String email, String adresse, String postleitzahl, String ort) {
        this.namekrzl = namekrzl;
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.adresse = adresse;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
    }

    public Mechaniker() {}

    public int getMechaniker_id() {
        return mechaniker_id;
    }

    public void setMechaniker_id(int mechaniker_id) {
        this.mechaniker_id = mechaniker_id;
    }

    public String getNamekrzl() {
        return namekrzl;
    }

    public void setNamekrzl(String namekrzl) {
        this.namekrzl = namekrzl;
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

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechaniker that = (Mechaniker) o;
        return mechaniker_id == that.mechaniker_id && Objects.equals(namekrzl, that.namekrzl) && Objects.equals(vorname, that.vorname) && Objects.equals(nachname, that.nachname) && Objects.equals(telefonnummer, that.telefonnummer) && Objects.equals(email, that.email) && Objects.equals(postleitzahl, that.postleitzahl) && Objects.equals(ort, that.ort) && Objects.equals(adresse, that.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mechaniker_id, namekrzl, vorname, nachname, telefonnummer, email, postleitzahl, ort, adresse);
    }
}
