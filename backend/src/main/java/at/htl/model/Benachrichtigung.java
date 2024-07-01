package at.htl.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Benachrichtigung {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Nachricht;

    @Column
    private Date Datum;

    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    public Benachrichtigung(String nachricht, Date datum, Kunde kunde) {
        Nachricht = nachricht;
        Datum = datum;
        this.kunde = kunde;
    }

    public Benachrichtigung() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNachricht() {
        return Nachricht;
    }

    public void setNachricht(String nachricht) {
        Nachricht = nachricht;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benachrichtigung that = (Benachrichtigung) o;
        return Objects.equals(id, that.id) && Objects.equals(Nachricht, that.Nachricht) && Objects.equals(Datum, that.Datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Nachricht, Datum);
    }
}
