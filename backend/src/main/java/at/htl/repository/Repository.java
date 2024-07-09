package at.htl.repository;

import at.htl.model.*;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class Repository {

    @Inject
    EntityManager em;


    /**
     * Der Kunde schickt dem Verwalter eine Anfrage für einen Servicetermin für sein Fahrzeug
     * @Parameter Fahrzeug_Id, Service_Id, Kunde_Id
     * @return
     */
    public Response sendTerminRequest(String Kennzeichen, String Service_Id, String Kunde_Id) {
        try {
            return Response.ok("sent successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to sent").build();
        }
    }

    

    /**
     * Delete value from the table
     * @return Response 200
     */

    /**
     * Update value from the table
     * @return Response 200
     */

    /**
     * Filter the table
     * @return Object
     */



    @Transactional
    public List<Kunde> getAllKunden() {
        return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
    }

    @Transactional
    public List<Benachrichtigung> getAllBenachrichtigung() {
        return em.createQuery("SELECT b from Benachrichtigung b", Benachrichtigung.class).getResultList();
    }

    @Transactional
    public List<Fahrzeug> getAllFahrzeug() {
        return em.createQuery("SELECT fa FROM Fahrzeug fa", Fahrzeug.class).getResultList();
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
    public List<Service> getAllService() {
        return em.createQuery("SELECT s FROM Service s", Service.class).getResultList();
    }

    @Transactional
    public List<Termin> getAllTermine() {
        return em.createQuery("SELECT t FROM Termin t ", Termin.class).getResultList();
    }

    @Transactional
    public List<Verleihauto> getAllVerleihauto() {
        return em.createQuery("SELECT v FROM Verleihauto v", Verleihauto.class).getResultList();
    }

    @Transactional
    public List<Verwalter> getAllVerwalter() {
        return em.createQuery("select v from Verwalter v", Verwalter.class).getResultList();
    }

    @Transactional
    public List<Wartungsverlauf> getAllWartungsverlauf() {
        return em.createQuery("select w from Wartungsverlauf w", Wartungsverlauf.class).getResultList();
    }

}
