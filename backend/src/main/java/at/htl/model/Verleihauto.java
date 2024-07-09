package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Verleihauto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verleihautoSeq")
    @SequenceGenerator(name = "verleihautoSeq", sequenceName = "verleihauto_id_seq", allocationSize = 1)
    private int verleihauto_id;

    private String marke;
    private String modell;
    private char besetzt;

    @ManyToOne
    @JoinColumn(name = "verwalter_verwalter_id", nullable = false)
    @JsonBackReference
    private Verwalter verwalter;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id")
    @JsonBackReference
    private Kunde kunde;

    // Getters and Setters

    public Verleihauto() {
    }

    public Verleihauto(int verleihauto_id, String marke, String modell, char besetzt, Verwalter verwalter, Kunde kunde) {
        this.verleihauto_id = verleihauto_id;
        this.marke = marke;
        this.modell = modell;
        this.besetzt = besetzt;
        this.verwalter = verwalter;
        this.kunde = kunde;
    }

    public int getVerleihauto_id() {
        return verleihauto_id;
    }

    public void setVerleihauto_id(int verleihauto_id) {
        this.verleihauto_id = verleihauto_id;
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

    public char getBesetzt() {
        return besetzt;
    }

    public void setBesetzt(char besetzt) {
        this.besetzt = besetzt;
    }

    public Verwalter getVerwalter() {
        return verwalter;
    }

    public void setVerwalter(Verwalter verwalter) {
        this.verwalter = verwalter;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
