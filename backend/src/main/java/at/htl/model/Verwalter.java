package at.htl.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Verwalter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int verwalter_id;

    private String namekrzl;
    private String vorname;
    private String nachname;
    private String telefonnummer;
    private String email;
    private String adresse;

    @OneToMany(mappedBy = "verwalter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReparaturEintrag> reparaturEintragList = new LinkedList<>();

    @OneToMany(mappedBy = "verwalter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Termin> terminList = new LinkedList<>();

    public Verwalter(String namekrzl, String vorname, String nachname, String telefonnummer, String email, String adresse) {
        this.namekrzl = namekrzl;
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.adresse = adresse;
    }

    public Verwalter() {}


    public int getVerwalter_id() {
        return verwalter_id;
    }

    public void setVerwalter_id(int verwalter_id) {
        this.verwalter_id = verwalter_id;
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

    public List<ReparaturEintrag> getReparaturEintragList() {
        return reparaturEintragList;
    }

    public void setReparaturEintragList(List<ReparaturEintrag> reparaturEintragList) {
        this.reparaturEintragList = reparaturEintragList;
    }

    public List<Termin> getTerminList() {
        return terminList;
    }

    public void setTerminList(List<Termin> terminList) {
        this.terminList = terminList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verwalter verwalter = (Verwalter) o;
        return verwalter_id == verwalter.verwalter_id && Objects.equals(namekrzl, verwalter.namekrzl) && Objects.equals(vorname, verwalter.vorname) && Objects.equals(nachname, verwalter.nachname) && Objects.equals(telefonnummer, verwalter.telefonnummer) && Objects.equals(email, verwalter.email) && Objects.equals(adresse, verwalter.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verwalter_id, namekrzl, vorname, nachname, telefonnummer, email, adresse);
    }
}
