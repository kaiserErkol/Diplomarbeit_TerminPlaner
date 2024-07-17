package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.glassfish.jaxb.core.v2.TODO;

import java.util.*;

@Entity
public class Reparatur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reparatur_id;

    private String beschreibung;
    private Date wunschtag_start; //früheste gewünschte Datum für den Beginn der Reparatur
    private Date wunschtag_end; //späteste gewünschte Datum für den Beginn der Reparatur

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fahrzeug_id", nullable = false)
    private Fahrzeug fahrzeug;

    @OneToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id")
    private Feedback feedback;

    @OneToOne
    @JoinColumn(name = "termin_id", referencedColumnName = "termin_id")
    private Termin termin;

    @OneToOne
    @JoinColumn(name = "kostenvrs_id", referencedColumnName = "kostenvrs_id")
    private Kostenvorschlag kostenvorschlag;

    @OneToOne
    @JoinColumn(name = "eintrag_id", referencedColumnName = "eintrag_id")
    private ReparaturEintrag reparaturEintrag;

    /**
     * @TODO
     * Fix the ManyToMany Relationship between Reparatur and Reparaturtyp
     */
/*
    @OneToMany(mappedBy = "reparatur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reparaturtyp> reparaturtypList;
*/
    public Reparatur(String beschreibung, Date wunschtag_start, Date wunschtag_end,Kunde kunde, Fahrzeug fahrzeug, Feedback feedback, Termin termin, Kostenvorschlag kostenvorschlag, ReparaturEintrag reparaturEintrag) {
        this.beschreibung = beschreibung;
        this.wunschtag_start = wunschtag_start;
        this.wunschtag_end = wunschtag_end;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.feedback = feedback;
        this.termin = termin;
        this.kostenvorschlag = kostenvorschlag;
        this.reparaturEintrag = reparaturEintrag;
    }

    public Reparatur() {
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

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public int getReparatur_id() {
        return reparatur_id;
    }

    public void setReparatur_id(int reparatur_id) {
        this.reparatur_id = reparatur_id;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Kostenvorschlag getKostenvorschlag() {
        return kostenvorschlag;
    }

    public void setKostenvorschlag(Kostenvorschlag kostenvorschlag) {
        this.kostenvorschlag = kostenvorschlag;
    }

    public ReparaturEintrag getReparaturEintrag() {
        return reparaturEintrag;
    }

    public void setReparaturEintrag(ReparaturEintrag reparaturEintrag) {
        this.reparaturEintrag = reparaturEintrag;
    }

    /*
    public List<Reparaturtyp> getReparaturtypList() {
        return reparaturtypList;
    }

    public void setReparaturtypList(List<Reparaturtyp> reparaturtypList) {
        this.reparaturtypList = reparaturtypList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reparatur reparatur = (Reparatur) o;
        return reparatur_id == reparatur.reparatur_id && Objects.equals(beschreibung, reparatur.beschreibung) && Objects.equals(wunschtag_start, reparatur.wunschtag_start) && Objects.equals(wunschtag_end, reparatur.wunschtag_end) && Objects.equals(kunde, reparatur.kunde) && Objects.equals(fahrzeug, reparatur.fahrzeug) && Objects.equals(feedback, reparatur.feedback) && Objects.equals(reparaturtypList, reparatur.reparaturtypList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reparatur_id, beschreibung, wunschtag_start, wunschtag_end, kunde, fahrzeug, feedback, reparaturtypList);
    }
    */

}
