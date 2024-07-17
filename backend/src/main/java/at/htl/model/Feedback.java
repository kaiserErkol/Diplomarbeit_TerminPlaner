package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedback_id;

    private String bewertung;
    private String kommentar;

    @JsonIgnore
    @OneToOne(mappedBy = "feedback", cascade = CascadeType.ALL)
    private Reparatur reparatur;

    public Feedback(String bewertung, String kommentar, Reparatur reparatur) {
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.reparatur = reparatur;
    }

    public Feedback() {}

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getBewertung() {
        return bewertung;
    }

    public void setBewertung(String bewertung) {
        this.bewertung = bewertung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

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
        Feedback feedback = (Feedback) o;
        return feedback_id == feedback.feedback_id && Objects.equals(bewertung, feedback.bewertung) && Objects.equals(kommentar, feedback.kommentar) && Objects.equals(reparatur, feedback.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_id, bewertung, kommentar, reparatur);
    }
}
