package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Fahrzeug {

    @Id
    private String fahrzeug_id;

    private String marke;
    private String modell;
    private Date baujahr;
    private int kilometerstand;
    private String zulassungsschein;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id", nullable = false)
    @JsonBackReference
    private Kunde kunde;

    @OneToMany(mappedBy = "fahrzeug",  cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Wartungsverlauf> wartungsverlaeufe;

    // Getters and Setters

    public Fahrzeug() {
    }

    public Fahrzeug(String fahrzeug_id, String marke, String modell, Date baujahr, int kilometerstand, String zulassungsschein, Kunde kunde) {
        this.fahrzeug_id = fahrzeug_id;
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.kilometerstand = kilometerstand;
        this.zulassungsschein = zulassungsschein;
        this.kunde = kunde;
    }

    public String getFahrzeug_id() {
        return fahrzeug_id;
    }

    public void setFahrzeug_id(String fahrzeug_id) {
        this.fahrzeug_id = fahrzeug_id;
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

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public String getZulassungsschein() {
        return zulassungsschein;
    }

    public void setZulassungsschein(String zulassungsschein) {
        this.zulassungsschein = zulassungsschein;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<Wartungsverlauf> getWartungsverlaeufe() {
        return wartungsverlaeufe;
    }

    public void setWartungsverlaeufe(List<Wartungsverlauf> wartungsverlaeufe) {
        this.wartungsverlaeufe = wartungsverlaeufe;
    }
}
