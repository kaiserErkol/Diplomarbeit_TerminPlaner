package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Kostenvorschlag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kostenvorschlagSeq")
    @SequenceGenerator(name = "kostenvorschlagSeq", sequenceName = "kostenvorschlag_id_seq", allocationSize = 1)
    private int kostenvorschlag_id;

    private double kosten;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id", nullable = false)
    @JsonBackReference
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "verwalter_verwalter_id", nullable = false)
    @JsonBackReference
    private Verwalter verwalter;

    // Getters and Setters

    public Kostenvorschlag() {
    }

    public Kostenvorschlag(int kostenvorschlag_id, double kosten, Kunde kunde, Verwalter verwalter) {
        this.kostenvorschlag_id = kostenvorschlag_id;
        this.kosten = kosten;
        this.kunde = kunde;
        this.verwalter = verwalter;
    }

    public int getKostenvorschlag_id() {
        return kostenvorschlag_id;
    }

    public void setKostenvorschlag_id(int kostenvorschlag_id) {
        this.kostenvorschlag_id = kostenvorschlag_id;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Verwalter getVerwalter() {
        return verwalter;
    }

    public void setVerwalter(Verwalter verwalter) {
        this.verwalter = verwalter;
    }
}
