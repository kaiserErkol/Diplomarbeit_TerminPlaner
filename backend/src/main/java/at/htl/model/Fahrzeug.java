package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Fahrzeug {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Marke;

    @Column
    private String Modell;

    @Column
    private Date Baujahr;

    @Column
    private String Kennzeichen;

    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @OneToMany(mappedBy = "fahrzeug", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Termin> termine;

    @OneToMany(mappedBy = "fahrzeug", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Wartungseintrag> wartungseintrag;

    public Fahrzeug(Kunde kunde, String kennzeichen, Date baujahr, String modell, String marke) {
        this.kunde = kunde;
        Kennzeichen = kennzeichen;
        Baujahr = baujahr;
        Modell = modell;
        Marke = marke;
    }

    public Fahrzeug() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarke() {
        return Marke;
    }

    public void setMarke(String marke) {
        Marke = marke;
    }

    public String getModell() {
        return Modell;
    }

    public void setModell(String modell) {
        Modell = modell;
    }

    public Date getBaujahr() {
        return Baujahr;
    }

    public void setBaujahr(Date baujahr) {
        Baujahr = baujahr;
    }

    public String getKennzeichen() {
        return Kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        Kennzeichen = kennzeichen;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public List<Wartungseintrag> getWartungseintrag() {
        return wartungseintrag;
    }

    public void setWartungseintrag(List<Wartungseintrag> wartungseintrag) {
        this.wartungseintrag = wartungseintrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fahrzeug fahrzeug = (Fahrzeug) o;
        return Objects.equals(id, fahrzeug.id) && Objects.equals(Marke, fahrzeug.Marke) && Objects.equals(Modell, fahrzeug.Modell) && Objects.equals(Baujahr, fahrzeug.Baujahr) && Objects.equals(Kennzeichen, fahrzeug.Kennzeichen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Marke, Modell, Baujahr, Kennzeichen);
    }
}
