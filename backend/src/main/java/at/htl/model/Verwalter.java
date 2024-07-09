package at.htl.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Verwalter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verwalterSeq")
    @SequenceGenerator(name = "verwalterSeq", sequenceName = "verwalter_id_seq", allocationSize = 1)
    private int verwalter_id;

    private String bezeichnung;

    @OneToMany(mappedBy = "verwalter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Kostenvorschlag> kostenvorschlaege;

    @OneToMany(mappedBy = "verwalter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Termin> termine;

    @OneToMany(mappedBy = "verwalter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TerminVorschlag> terminvorschlaege;

    @OneToMany(mappedBy = "verwalter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Verleihauto> verleihautos;

    // Getters and Setters


    public Verwalter() {
    }

    public int getVerwalter_id() {
        return verwalter_id;
    }

    public void setVerwalter_id(int verwalter_id) {
        this.verwalter_id = verwalter_id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public List<Kostenvorschlag> getKostenvorschlaege() {
        return kostenvorschlaege;
    }

    public void setKostenvorschlaege(List<Kostenvorschlag> kostenvorschlaege) {
        this.kostenvorschlaege = kostenvorschlaege;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public List<TerminVorschlag> getTerminvorschlaege() {
        return terminvorschlaege;
    }

    public void setTerminvorschlaege(List<TerminVorschlag> terminvorschlaege) {
        this.terminvorschlaege = terminvorschlaege;
    }

    public List<Verleihauto> getVerleihautos() {
        return verleihautos;
    }

    public void setVerleihautos(List<Verleihauto> verleihautos) {
        this.verleihautos = verleihautos;
    }
}
