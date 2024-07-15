package at.htl.model;

import at.htl.enums.ReparaturStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class ReparaturEintrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eintragId;

    private String beschreibung;
    private Date abschlussdatum;

    @Enumerated(EnumType.STRING)
    private ReparaturStatus status;

    @OneToOne
    @JoinColumn(name = "r_reparatur_id", nullable = false, unique = true)
    private Reparatur reparatur;

    @ManyToOne
    @JoinColumn(name = "v_verwalter_id", nullable = false)
    private Verwalter verwalter;

    public ReparaturEintrag(String beschreibung, Date abschlussdatum, ReparaturStatus status, Reparatur reparatur, Verwalter verwalter) {
        this.beschreibung = beschreibung;
        this.abschlussdatum = abschlussdatum;
        this.status = status;
        this.reparatur = reparatur;
        this.verwalter = verwalter;
    }

    public ReparaturEintrag() {}

    public int getEintragId() {
        return eintragId;
    }

    public void setEintragId(int eintragId) {
        this.eintragId = eintragId;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getAbschlussdatum() {
        return abschlussdatum;
    }

    public void setAbschlussdatum(Date abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }

    public ReparaturStatus getStatus() {
        return status;
    }

    public void setStatus(ReparaturStatus status) {
        this.status = status;
    }

    public Reparatur getReparatur() {
        return reparatur;
    }

    public void setReparatur(Reparatur reparatur) {
        this.reparatur = reparatur;
    }

    public Verwalter getVerwalter() {
        return verwalter;
    }

    public void setVerwalter(Verwalter verwalter) {
        this.verwalter = verwalter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReparaturEintrag that = (ReparaturEintrag) o;
        return eintragId == that.eintragId && Objects.equals(beschreibung, that.beschreibung) && Objects.equals(abschlussdatum, that.abschlussdatum) && Objects.equals(status, that.status) && Objects.equals(reparatur, that.reparatur) && Objects.equals(verwalter, that.verwalter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eintragId, beschreibung, abschlussdatum, status, reparatur, verwalter);
    }
}
