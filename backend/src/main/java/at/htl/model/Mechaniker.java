package at.htl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Mechaniker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mechanikerSeq")
    @SequenceGenerator(name = "mechanikerSeq", sequenceName = "mechaniker_id_seq", allocationSize = 1)
    private int mechaniker_id;

    private String vorname;
    private String nachname;
    private String namenkuerzel;
    private String telefon;

    @ManyToOne
    @JoinColumn(name = "termin_termin_id", nullable = false)
    @JsonBackReference
    private Termin termin;

    @OneToMany(mappedBy = "mechaniker", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Wartungsverlauf> wartungsverlaeufe;

    // Getters and Setters

    public Mechaniker() {
    }

    public Mechaniker(int mechaniker_id, String vorname, String nachname, String namenkuerzel, String telefon, Termin termin) {
        this.mechaniker_id = mechaniker_id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.namenkuerzel = namenkuerzel;
        this.telefon = telefon;
        this.termin = termin;
    }

    public int getMechaniker_id() {
        return mechaniker_id;
    }

    public void setMechaniker_id(int mechaniker_id) {
        this.mechaniker_id = mechaniker_id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNamenkuerzel() {
        return namenkuerzel;
    }

    public void setNamenkuerzel(String namenkuerzel) {
        this.namenkuerzel = namenkuerzel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public List<Wartungsverlauf> getWartungsverlaeufe() {
        return wartungsverlaeufe;
    }

    public void setWartungsverlaeufe(List<Wartungsverlauf> wartungsverlaeufe) {
        this.wartungsverlaeufe = wartungsverlaeufe;
    }
}
