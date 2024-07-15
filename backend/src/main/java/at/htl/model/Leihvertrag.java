package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Leihvertrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vertragId;

    private Date ausleihdatum;
    private Date rueckgabedatum;

    @OneToOne
    @JoinColumn(name = "k_kunde_id", nullable = false, unique = true)
    private Kunde kunde;

    @OneToOne
    @JoinColumn(name = "lf_leihf_id", nullable = false, unique = true)
    private Leihfahrzeug leihfahrzeug;

    public Leihvertrag(Date ausleihdatum, Date rueckgabedatum, Kunde kunde, Leihfahrzeug leihfahrzeug) {
        this.ausleihdatum = ausleihdatum;
        this.rueckgabedatum = rueckgabedatum;
        this.kunde = kunde;
        this.leihfahrzeug = leihfahrzeug;
    }

    public Leihvertrag() {}

    public int getVertragId() {
        return vertragId;
    }

    public void setVertragId(int vertragId) {
        this.vertragId = vertragId;
    }

    public Date getAusleihdatum() {
        return ausleihdatum;
    }

    public void setAusleihdatum(Date ausleihdatum) {
        this.ausleihdatum = ausleihdatum;
    }

    public Date getRueckgabedatum() {
        return rueckgabedatum;
    }

    public void setRueckgabedatum(Date rueckgabedatum) {
        this.rueckgabedatum = rueckgabedatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Leihfahrzeug getLeihfahrzeug() {
        return leihfahrzeug;
    }

    public void setLeihfahrzeug(Leihfahrzeug leihfahrzeug) {
        this.leihfahrzeug = leihfahrzeug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leihvertrag that = (Leihvertrag) o;
        return vertragId == that.vertragId && Objects.equals(ausleihdatum, that.ausleihdatum) && Objects.equals(rueckgabedatum, that.rueckgabedatum) && Objects.equals(kunde, that.kunde) && Objects.equals(leihfahrzeug, that.leihfahrzeug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertragId, ausleihdatum, rueckgabedatum, kunde, leihfahrzeug);
    }
}
