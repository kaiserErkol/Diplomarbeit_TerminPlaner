package at.htl.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Leihfahrzeug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leihf_id;

    private String kennzeichen;
    private String marke;
    private String modell;
    private char besetzt;

    @OneToOne(mappedBy = "leihfahrzeug", cascade = CascadeType.ALL)
    private Leihvertrag leihvertrag;

    public Leihfahrzeug(String kennzeichen, String marke, String modell, char besetzt, Leihvertrag leihvertrag) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.modell = modell;
        this.besetzt = besetzt;
        this.leihvertrag = leihvertrag;
    }

    public Leihfahrzeug() {}

    public int getLeihf_id() {
        return leihf_id;
    }

    public void setLeihf_id(int leihf_id) {
        this.leihf_id = leihf_id;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public char getBesetzt() {
        return besetzt;
    }

    public void setBesetzt(char besetzt) {
        this.besetzt = besetzt;
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
        Leihfahrzeug that = (Leihfahrzeug) o;
        return leihf_id == that.leihf_id && besetzt == that.besetzt && Objects.equals(kennzeichen, that.kennzeichen) && Objects.equals(marke, that.marke) && Objects.equals(modell, that.modell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leihf_id, kennzeichen, marke, modell, besetzt);
    }
}
