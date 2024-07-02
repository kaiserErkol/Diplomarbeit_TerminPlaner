package at.htl.repository;

import at.htl.model.Kunde;
import at.htl.model.Termin;
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
    public List<Termin> getAllTermine() {
        return em.createQuery("SELECT t FROM Termin t", Termin.class).getResultList();
    }

    @Transactional
    public List<Kunde> getAllKunden() {
        return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
    }
}


//test 1