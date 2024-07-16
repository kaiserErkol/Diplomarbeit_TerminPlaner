package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Reparatur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reparaturId;

    private String beschreibung;
    private Date wunschtag_start; //früheste gewünschte Datum für den Beginn der Reparatur
    private Date wunschtag_end; //späteste gewünschte Datum für den Beginn der Reparatur

    @ManyToOne
    @JoinColumn(name = "k_kunde_id", nullable = false)
    private Kunde kunde;

    @ManyToOne()
    @JoinColumn(name = "f_fahrzeug_id", nullable = false)
    private Fahrzeug fahrzeug;

    @ManyToOne
    @JoinColumn(name = "rt_reptyp_id", nullable = false)
    private Reparaturtyp reparaturtyp;

    @OneToMany(mappedBy = "reparatur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;

    public Reparatur(String beschreibung, Date wunschtag_start, Date wunschtag_end,Kunde kunde, Fahrzeug fahrzeug, Reparaturtyp reparaturtyp) {
        this.beschreibung = beschreibung;
        this.wunschtag_start = wunschtag_start;
        this.wunschtag_end = wunschtag_end;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.reparaturtyp = reparaturtyp;
    }

    public Reparatur() {}

    public int getReparaturId() {
        return reparaturId;
    }

    public void setReparaturId(int reparaturId) {
        this.reparaturId = reparaturId;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getWunschtag_start() {
        return wunschtag_start;
    }

    public void setWunschtag_start(Date wunschtag_start) {
        this.wunschtag_start = wunschtag_start;
    }

    public Date getWunschtag_end() {
        return wunschtag_end;
    }

    public void setWunschtag_end(Date wunschtag_end) {
        this.wunschtag_end = wunschtag_end;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public Reparaturtyp getReparaturtyp() {
        return reparaturtyp;
    }

    public void setReparaturtyp(Reparaturtyp reparaturtyp) {
        this.reparaturtyp = reparaturtyp;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reparatur reparatur = (Reparatur) o;
        return reparaturId == reparatur.reparaturId && Objects.equals(beschreibung, reparatur.beschreibung) && Objects.equals(kunde, reparatur.kunde) && Objects.equals(fahrzeug, reparatur.fahrzeug) && Objects.equals(reparaturtyp, reparatur.reparaturtyp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reparaturId, beschreibung, kunde, fahrzeug, reparaturtyp);
    }
}
