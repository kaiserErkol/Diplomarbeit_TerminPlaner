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

    // Getters and Setters

    public Verleihauto() {
    }

    public Verleihauto(int verleihauto_id, String marke, String modell, char besetzt) {
        this.verleihauto_id = verleihauto_id;
        this.marke = marke;
        this.modell = modell;
        this.besetzt = besetzt;
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
}
