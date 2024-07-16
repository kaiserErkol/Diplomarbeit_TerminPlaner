package at.htl.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;


    public Fahrzeug(String kennzeichen, String marke, String modell, Date baujahr, String zulassungsscheinRoot, Kunde kunde) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.zulassungsscheinRoot = zulassungsscheinRoot;
        this.kunde = kunde;
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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrzeug fahrzeug = (Fahrzeug) o;
        return fahrzeugId == fahrzeug.fahrzeugId && Objects.equals(kennzeichen, fahrzeug.kennzeichen) && Objects.equals(marke, fahrzeug.marke) && Objects.equals(modell, fahrzeug.modell) && Objects.equals(baujahr, fahrzeug.baujahr) && Objects.equals(zulassungsscheinRoot, fahrzeug.zulassungsscheinRoot) && Objects.equals(kunde, fahrzeug.kunde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fahrzeugId, kennzeichen, marke, modell, baujahr, zulassungsscheinRoot, kunde);
    }
}
