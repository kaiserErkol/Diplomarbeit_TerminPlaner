package at.htl.repository;

import at.htl.model.Kunde;
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

    public List<Kunde> getAllKunden() {
        return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
    }

}
