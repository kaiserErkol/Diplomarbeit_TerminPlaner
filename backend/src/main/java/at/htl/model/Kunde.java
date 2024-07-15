package at.htl.model;

import jakarta.persistence.*;

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
    private String adresse;

    @OneToMany(mappedBy = "kunde", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reparatur> reparaturList;

    public Kunde(String vorname, String nachname, String email, String telefonnummer, String adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }

    public Kunde() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kunde kunde = (Kunde) o;
        return kunde_id == kunde.kunde_id && Objects.equals(vorname, kunde.vorname) && Objects.equals(nachname, kunde.nachname) && Objects.equals(email, kunde.email) && Objects.equals(telefonnummer, kunde.telefonnummer) && Objects.equals(adresse, kunde.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kunde_id, vorname, nachname, email, telefonnummer, adresse);
    }
}
