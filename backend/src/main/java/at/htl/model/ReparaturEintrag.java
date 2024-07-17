package at.htl.model;

import at.htl.enums.ReparaturStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class ReparaturEintrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eintrag_id;

    private String beschreibung;

    @Column(nullable = true)
    private Date abschlussdatum;

    @Enumerated(EnumType.STRING)
    private ReparaturStatus status;

    @JsonIgnore
    @OneToOne (mappedBy = "reparaturEintrag", cascade = CascadeType.ALL)
    private Reparatur reparatur;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verwalter_id", nullable = false)
    private Verwalter verwalter;

    public ReparaturEintrag(String beschreibung, Date abschlussdatum, ReparaturStatus status, Reparatur reparatur, Verwalter verwalter) {
        this.beschreibung = beschreibung;
        this.abschlussdatum = abschlussdatum;
        this.status = status;
        this.reparatur = reparatur;
        this.verwalter = verwalter;
    }

    public ReparaturEintrag() {}

    public int getEintrag_id() {
        return eintrag_id;
    }

    public void setEintrag_id(int eintrag_id) {
        this.eintrag_id = eintrag_id;
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
        return eintrag_id == that.eintrag_id && Objects.equals(beschreibung, that.beschreibung) && Objects.equals(abschlussdatum, that.abschlussdatum) && Objects.equals(status, that.status) && Objects.equals(reparatur, that.reparatur) && Objects.equals(verwalter, that.verwalter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eintrag_id, beschreibung, abschlussdatum, status, reparatur, verwalter);
    }
}
