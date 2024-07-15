package at.htl.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    private String bewertung;
    private String kommentar;

    @ManyToOne
    @JoinColumn(name = "r_reparatur_id", nullable = false)
    private Reparatur reparatur;

    public Feedback(String bewertung, String kommentar, Reparatur reparatur) {
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.reparatur = reparatur;
    }

    public Feedback() {}

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
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
        return feedbackId == feedback.feedbackId && Objects.equals(bewertung, feedback.bewertung) && Objects.equals(kommentar, feedback.kommentar) && Objects.equals(reparatur, feedback.reparatur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId, bewertung, kommentar, reparatur);
    }
}
