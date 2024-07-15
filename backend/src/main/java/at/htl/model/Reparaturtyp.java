package at.htl.model;

import at.htl.enums.Klassifikation;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Reparaturtyp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int retypId;

    private String bezeichnung;
    private int dauerinmin;

    @Enumerated(EnumType.STRING)
    private Klassifikation klassifikation;

    public Reparaturtyp(String bezeichnung, int dauerinmin, Klassifikation klassifikation) {
        this.bezeichnung = bezeichnung;
        this.dauerinmin = dauerinmin;
        this.klassifikation = klassifikation;
    }

    public Reparaturtyp() {}

    public int getRetypId() {
        return retypId;
    }

    public void setRetypId(int retypId) {
        this.retypId = retypId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reparaturtyp that = (Reparaturtyp) o;
        return retypId == that.retypId && dauerinmin == that.dauerinmin && Objects.equals(bezeichnung, that.bezeichnung) && Objects.equals(klassifikation, that.klassifikation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(retypId, bezeichnung, dauerinmin, klassifikation);
    }
}
