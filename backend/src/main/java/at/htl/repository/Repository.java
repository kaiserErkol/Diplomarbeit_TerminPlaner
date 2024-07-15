package at.htl.repository;

import at.htl.model.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class Repository {

    @Inject
    EntityManager em;

    @Transactional
    public List<Kunde> getAllKunde() {
        return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
    }

    @Transactional
    public List<Fahrzeug> getAllFahrzeug() {
        return em.createQuery("SELECT fa FROM Fahrzeug fa", Fahrzeug.class).getResultList();
    }

    @Transactional
    public List<Feedback> getAllFeedback() {
        return em.createQuery("SELECT f FROM Feedback f", Feedback.class).getResultList();
    }

    @Transactional
    public List<Reparaturtyp> getAllReparaturtyp() {
        return em.createQuery("SELECT rt FROM Reparaturtyp rt", Reparaturtyp.class).getResultList();
    }

    @Transactional
    public List<Kostenvorschlag> getAllKostenvorschlag() {
        return em.createQuery("select k from Kostenvorschlag k", Kostenvorschlag.class).getResultList();
    }

    @Transactional
    public List<Mechaniker> getAllMechaniker() {
        return em.createQuery("SELECT m FROM Mechaniker m", Mechaniker.class).getResultList();
    }

    @Transactional
    public List<Termin> getAllTermine() {
        return em.createQuery("SELECT t FROM Termin t ", Termin.class).getResultList();
    }

    @Transactional
    public List<Termin> getAllTerminvorschlag() {
        return em.createQuery("SELECT tv FROM Terminvorschlag tv", Termin.class).getResultList();
    }

    @Transactional
    public List<Leihfahrzeug> getAllLeihfahrzeug() {
        return em.createQuery("SELECT lf FROM Leihfahrzeug lf", Leihfahrzeug.class).getResultList();
    }

    @Transactional
    public List<Leihvertrag> getAllLeihvertrag() {
        return em.createQuery("SELECT lv FROM Leihvertrag lv", Leihvertrag.class).getResultList();
    }

    @Transactional
    public List<Verwalter> getAllVerwalter() {
        return em.createQuery("select v from Verwalter v", Verwalter.class).getResultList();
    }

    @Transactional
    public List<Reparatur> getAllReparatur() {
        return em.createQuery("select r from Reparatur r", Reparatur.class).getResultList();
    }
}
