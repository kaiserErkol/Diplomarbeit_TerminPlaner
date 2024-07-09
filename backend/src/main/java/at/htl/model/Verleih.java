package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Verleih {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verleihSeq")
    @SequenceGenerator(name = "verleihSeq", sequenceName = "verleih_id_seq", allocationSize = 1)
    private int verleih_id;

    private Date verleihDatum;
    private Date rueckgabeDatum;

    @ManyToOne
    @JoinColumn(name = "verleihauto_verleihauto_id")
    @JsonBackReference
    private Verleihauto verleihauto;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id")
    @JsonBackReference
    private Kunde kunde;

    public Verleih(Date verleihDatum, Date rueckgabeDatum, Verleihauto verleihauto, Kunde kunde) {
        this.verleihDatum = verleihDatum;
        this.rueckgabeDatum = rueckgabeDatum;
        this.verleihauto = verleihauto;
        this.kunde = kunde;
    }

    public Verleih() {
    }

    public int getVerleih_id() {
        return verleih_id;
    }

    public void setVerleih_id(int verleih_id) {
        this.verleih_id = verleih_id;
    }

    public Date getVerleihDatum() {
        return verleihDatum;
    }

    public void setVerleihDatum(Date verleihDatum) {
        this.verleihDatum = verleihDatum;
    }

    public Date getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(Date rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public Verleihauto getVerleihauto() {
        return verleihauto;
    }

    public void setVerleihauto(Verleihauto verleihauto) {
        this.verleihauto = verleihauto;
    }
}
