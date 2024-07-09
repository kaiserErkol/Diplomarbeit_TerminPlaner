package at.htl.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceSeq")
    @SequenceGenerator(name = "serviceSeq", sequenceName = "service_id_seq", allocationSize = 1)
    private int service_id;

    private String bezeichnung;
    private String beschreibung;
    private int dauerinmin;

    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private List<Termin> termine;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Wartungsverlauf> wartungsverlaeufe;

    // Getters and Setters

    public Service() {
    }

    public Service(int service_id, String bezeichnung, String beschreibung, int dauerinmin) {
        this.service_id = service_id;
        this.bezeichnung = bezeichnung;
        this.beschreibung = beschreibung;
        this.dauerinmin = dauerinmin;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getDauerinmin() {
        return dauerinmin;
    }

    public void setDauerinmin(int dauerinmin) {
        this.dauerinmin = dauerinmin;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public List<Wartungsverlauf> getWartungsverlaeufe() {
        return wartungsverlaeufe;
    }

    public void setWartungsverlaeufe(List<Wartungsverlauf> wartungsverlaeufe) {
        this.wartungsverlaeufe = wartungsverlaeufe;
    }
}
