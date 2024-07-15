package at.htl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Leihfahrzeug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leihfId;

    private String kennzeichen;
    private String marke;
    private String modell;
    private char besetzt;

    public Leihfahrzeug(String kennzeichen, String marke, String modell, char besetzt) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.modell = modell;
        this.besetzt = besetzt;
    }

    public Leihfahrzeug() {}

    public int getLeihfId() {
        return leihfId;
    }

    public void setLeihfId(int leihfId) {
        this.leihfId = leihfId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leihfahrzeug that = (Leihfahrzeug) o;
        return leihfId == that.leihfId && besetzt == that.besetzt && Objects.equals(kennzeichen, that.kennzeichen) && Objects.equals(marke, that.marke) && Objects.equals(modell, that.modell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leihfId, kennzeichen, marke, modell, besetzt);
    }
}
