package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Benachrichtigung {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "benachrichtigungSeq")
    @SequenceGenerator(name = "benachrichtigungSeq", sequenceName = "benachrichtigung_id_seq", allocationSize = 1)
    private int benachrichtigung_id;

    private String nachricht;
    private Date datum;

    @ManyToOne
    @JoinColumn(name = "kunde_kunde_id", nullable = false)
    @JsonBackReference
    private Kunde kunde;

    public Benachrichtigung() {
    }

    public Benachrichtigung(int benachrichtigung_id, String nachricht, Date datum, Kunde kunde) {
        this.benachrichtigung_id = benachrichtigung_id;
        this.nachricht = nachricht;
        this.datum = datum;
        this.kunde = kunde;
    }

    public int getBenachrichtigung_id() {
        return benachrichtigung_id;
    }

    public void setBenachrichtigung_id(int benachrichtigung_id) {
        this.benachrichtigung_id = benachrichtigung_id;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
