package at.htl.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Kunde {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String Vorname;

    @Column
    private String Nachname;

    @Column
    private String Email;

    @Column
    private String Telefonnummer;

    @Column
    private String Adresse;

    @OneToMany(mappedBy = "kunde", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Fahrzeug> fahrzeuge;

    @OneToMany(mappedBy = "kunde", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Termin> termine;

    @OneToMany(mappedBy = "kunde", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Benachrichtigung> benachrichtigungen;

    public Kunde(String vorname, String nachname, String email, String telefonnummer, String adresse) {
        Vorname = vorname;
        Nachname = nachname;
        Email = email;
        Telefonnummer = telefonnummer;
        Adresse = adresse;
    }

    public Kunde() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefonnummer() {
        return Telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        Telefonnummer = telefonnummer;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
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

    public List<Benachrichtigung> getBenachrichtigungen() {
        return benachrichtigungen;
    }

    public void setBenachrichtigungen(List<Benachrichtigung> benachrichtigungen) {
        this.benachrichtigungen = benachrichtigungen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kunde kunde = (Kunde) o;
        return id == kunde.id && Objects.equals(Vorname, kunde.Vorname) && Objects.equals(Nachname, kunde.Nachname) && Objects.equals(Email, kunde.Email) && Objects.equals(Telefonnummer, kunde.Telefonnummer) && Objects.equals(Adresse, kunde.Adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Vorname, Nachname, Email, Telefonnummer, Adresse);
    }
}
