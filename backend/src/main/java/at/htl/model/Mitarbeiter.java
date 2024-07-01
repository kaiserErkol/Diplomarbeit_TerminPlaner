package at.htl.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Mitarbeiter {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Vorname;

    @Column
    private String Nachname;

    @Column
    private String Email;

    @Column
    private String Telefonnummer;

    @OneToMany(mappedBy = "mitarbeiter", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Termin> termine;

    public Mitarbeiter(String vorname, String nachname, String email, String telefonnummer) {
        Vorname = vorname;
        Nachname = nachname;
        Email = email;
        Telefonnummer = telefonnummer;
    }

    public Mitarbeiter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mitarbeiter that = (Mitarbeiter) o;
        return Objects.equals(id, that.id) && Objects.equals(Vorname, that.Vorname) && Objects.equals(Nachname, that.Nachname) && Objects.equals(Email, that.Email) && Objects.equals(Telefonnummer, that.Telefonnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Vorname, Nachname, Email, Telefonnummer);
    }
}
