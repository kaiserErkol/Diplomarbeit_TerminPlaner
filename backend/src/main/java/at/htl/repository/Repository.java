package at.htl.repository;

import at.htl.model.*;
import io.smallrye.mutiny.Multi;
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
    public List<Kunde> getAllKunden() {
        return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
    }

    public List<Benachrichtigung> getAllBenachrichtigung() {
        return em.createQuery("SELECT b from Benachrichtigung b", Benachrichtigung.class).getResultList();
    }

    public List<Fahrzeug> getAllFahrzeug() {
        return em.createQuery("SELECT fa FROM Fahrzeug fa", Fahrzeug.class).getResultList();
    }

    public List<Kostenvorschlag> getAllKostenvorschlag() {
        return em.createQuery("select k from Kostenvorschlag k", Kostenvorschlag.class).getResultList();
    }

    public List<Mechaniker> getAllMechaniker() {
        return em.createQuery("SELECT m FROM Mechaniker m", Mechaniker.class).getResultList();
    }

    public List<Service> getAllService() {
        return em.createQuery("SELECT s FROM Service s", Service.class).getResultList();
    }

    public List<Termin> getAllTermine() {
        return em.createQuery("SELECT t FROM Termin t ", Termin.class).getResultList();
    }

    public List<Verleihauto> getAllVerleihauto() {
        return em.createQuery("SELECT v FROM Verleihauto v", Verleihauto.class).getResultList();
    }

    public List<Verwalter> getAllVerwalter() {
        return em.createQuery("select v from Verwalter v", Verwalter.class).getResultList();
    }

    public List<Wartungsverlauf> getAllWartungsverlauf() {
        return em.createQuery("select w from Wartungsverlauf w", Wartungsverlauf.class).getResultList();
    }

}
