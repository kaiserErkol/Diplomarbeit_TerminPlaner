package at.htl.model;

import jakarta.persistence.*;

@Entity
public class TerminMechaniker {
    @EmbeddedId
    private TerminMechanikerId id;

    @ManyToOne
    @MapsId("termin_id")
    @JoinColumn(name = "termin_id")
    private Termin termin;

    @ManyToOne
    @MapsId("mechaniker_id")
    @JoinColumn(name = "mechaniker_id")
    private Mechaniker mechaniker;

    public TerminMechaniker(Termin termin, Mechaniker mechaniker) {
        this.termin = termin;
        this.mechaniker = mechaniker;
    }

    public TerminMechaniker() {}

    public TerminMechanikerId getId() {
        return id;
    }

    public void setId(TerminMechanikerId id) {
        this.id = id;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Mechaniker getMechaniker() {
        return mechaniker;
    }

    public void setMechaniker(Mechaniker mechaniker) {
        this.mechaniker = mechaniker;
    }
}
