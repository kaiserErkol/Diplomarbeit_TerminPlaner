package at.htl.model;

import at.htl.enums.Klassifikation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Reparaturtyp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int retyp_id;

    private String bezeichnung;
    private String beschreibung;
    private int dauerinmin;

    @Enumerated(EnumType.STRING)
    private Klassifikation klassifikation;

    /*
    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "reparatur_id", nullable = false)
    private Reparatur reparatur;
*/
    public Reparaturtyp(String bezeichnung, String beschreibung, int dauerinmin, Klassifikation klassifikation) {
        //this.reparatur = reparatur;
        this.bezeichnung = bezeichnung;
        this.beschreibung = beschreibung;
        this.dauerinmin = dauerinmin;
        this.klassifikation = klassifikation;
    }

    public Reparaturtyp() {
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getDauerinmin() {
        return dauerinmin;
    }

    public void setDauerinmin(int dauerinmin) {
        this.dauerinmin = dauerinmin;
    }

    public Klassifikation getKlassifikation() {
        return klassifikation;
    }

    public void setKlassifikation(Klassifikation klassifikation) {
        this.klassifikation = klassifikation;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getRetyp_id() {
        return retyp_id;
    }

    public void setRetyp_id(int retyp_id) {
        this.retyp_id = retyp_id;
    }
/*
    public Reparatur getReparatur() {
        return reparatur;
    }

    public void setReparatur(Reparatur reparatur) {
        this.reparatur = reparatur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reparaturtyp that = (Reparaturtyp) o;
        return retyp_id == that.retyp_id && dauerinmin == that.dauerinmin && Objects.equals(bezeichnung, that.bezeichnung) && Objects.equals(beschreibung, that.beschreibung) && klassifikation == that.klassifikation && Objects.equals(reparatur, that.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(retyp_id, bezeichnung, beschreibung, dauerinmin, klassifikation, reparatur);
    }
    */

}
