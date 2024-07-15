package at.htl.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Fahrzeug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fahrzeugId;

    private String kennzeichen;
    private String marke;
    private String modell;
    private Date baujahr;     //java util
    private String zulassungsscheinRoot;

    public Fahrzeug(String kennzeichen, String marke, String modell, Date baujahr, String zulassungsscheinRoot) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.zulassungsscheinRoot = zulassungsscheinRoot;
    }

    public Fahrzeug() {}

    public int getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(int fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
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

    public Date getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(Date baujahr) {
        this.baujahr = baujahr;
    }

    public String getZulassungsscheinRoot() {
        return zulassungsscheinRoot;
    }

    public void setZulassungsscheinRoot(String zulassungsscheinRoot) {
        this.zulassungsscheinRoot = zulassungsscheinRoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrzeug fahrzeug = (Fahrzeug) o;
        return fahrzeugId == fahrzeug.fahrzeugId && Objects.equals(kennzeichen, fahrzeug.kennzeichen) && Objects.equals(marke, fahrzeug.marke) && Objects.equals(modell, fahrzeug.modell) && Objects.equals(baujahr, fahrzeug.baujahr) && Objects.equals(zulassungsscheinRoot, fahrzeug.zulassungsscheinRoot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fahrzeugId, kennzeichen, marke, modell, baujahr, zulassungsscheinRoot);
    }
}
