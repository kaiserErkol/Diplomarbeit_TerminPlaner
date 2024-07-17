package at.htl.repository;

import at.htl.enums.Arbeitstagen;
import at.htl.model.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class Repository {

    @Inject
    EntityManager em;

    /**
     * Der Kunde erstellt einen Eintrag in der Reparaturtabelle;
     * das Feedback und Termin bleibt leer
     * @Parameter kundeId, kennzeichen, reparaturtypId, wunschTag_start, wunschTag_end
     * @return Response
     */
    public Response createReparatur(int kundeId, String kennzeichen, int reparaturtypId, Date wunschTag_start, Date wunschTag_end) {
        try {
            return Response.ok("created Reparatur successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to create Reparatur").build();
        }
    }

    /**
     * Der Verwalter bekommt mit, dass ein neuer Eintrag in der Reparatur erstellt wurde.
     * Mit den Informationen aus dem Eintrag erstellt er einen Kostenvorschlag, der dem
     * Kunde zur Bestätigung vorgelegt wird.
     * @Parameter reparaturId
     * @return Response
     */
    public Response createKostenvorschlag(int reparaturId) {
        try {
            return Response.ok("created Kostenvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to create Kostenvorschlag").build();
        }
    }

    /**
     * Der Kunde akzeptiert/lehnt ab den Kostenvorschlag
     * @Parameter
     * @return Response
     */
    public Response acceptKostenvorschlag(int kostenvrsId) {
        try {
            return Response.ok("accepted Kostenvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to accept Kostenvorschlag").build();
        }
    }
    public Response rejectKostenvorschlag(int kostenvrsId) {
        try {
            return Response.ok("rejected Kostenvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to reject Kostenvorschlag").build();
        }
    }

    /**
     * Der Verwalter generiert für den Kunden einen von vielen Terminvorschläge;
     * eines davon muss vom Kunden akzeptiert werden, damit es zu einem fixen Termin wird.
     * @Parameter wunschTage
     * @return Response
     */
    public Response createTerminvorschlag(List<Arbeitstagen> wunschTage) {
        try {
            return Response.ok("created Terminvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to create Terminvorschlag").build();
        }
    }

    /**
     * Der Kunde akzeptiert einen der passenden Terminvorschlägen, wenn keines akzeptiert wird
     * kann er neue Anfragen bis es einen passenden gibt;
     * Nice to Have Idee: Das Verhaltensmuster wird gespeichert und die nächsten
     * Terminvorschlägen sind präziser
     * @Parameter terminvorsId
     * @return Response
     */
    public Response acceptTerminvorschlag(int terminvorschrsId) {
        try {
            return Response.ok("accepted Terminvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to accept Terminvorschlag").build();
        }
    }
    public Response rejectTerminvorschlag(int terminvorschrsId) {
        try {
            return Response.ok("rejected Terminvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to reject Terminvorschlag").build();
        }
    }

    /**
     * Nachdem einer der Terminvorschläge akzeptiert wurde, wird es in der Termin
     * Tabelle die bereits erstellte Eintrag updated (Kunde hat ganz am Anfang schon einen erstellt)
     * @Parameter terminvorschlagId, notiz, terminstatus, reparaturId, verwalterId
     * @return Response
     */
    public Response updateTermin() {
        try {
            return Response.ok("updated Termin successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to update Termin").build();
        }
    }

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
    public List<Terminvorschlag> getAllTerminvorschlag() {
        return em.createQuery("SELECT tv FROM Terminvorschlag tv", Terminvorschlag.class).getResultList();
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

    @Transactional
    public List<MechanikerZuteilung> getAllMechanikerZuteilung() {
        return em.createQuery("select mz from MechanikerZuteilung mz", MechanikerZuteilung.class).getResultList();
    }

    @Transactional
    public List<ServiceZuteilung> getAllServiceZuteilung() {
        return em.createQuery("select sz from ServiceZuteilung sz", ServiceZuteilung.class).getResultList();
    }
}
