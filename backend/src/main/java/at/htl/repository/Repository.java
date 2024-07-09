package at.htl.repository;

import at.htl.enums.TerminStatus;
import at.htl.model.*;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class Repository {

    @Inject
    EntityManager em;


    /**
     * Der Kunde schickt dem Verwalter eine Anfrage für einen Servicetermin für sein Fahrzeug
     * @Parameter String fahrzeug_Id, int service_Id, int kunde_Id, int kilometerstand
     * @return Response
     */
    public Response sendTerminanfrage(int kunde_Id, TerminAnfrage terminAnfrage) {
        try {
            return Response.ok("sent Terminanfrage successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to send Terminanfrage").build();
        }
    }

    /**
     * erstellt die Terminanfrage
     * @Parameter String fahrzeug_Id, int service_Id, int kunde_Id, int kilometerstand, date datum, String notiz
     * @return Terminanfrage
     */
    public TerminAnfrage createTerminanfrage(String fahrzeug_Id, int service_Id, int kunde_Id, int kilometerstand, Date datum, String notiz) {
        return null;
    }

    /**
     * Der Verwalter schickt dem Kunden einen Kostenvorschlag für den verlangten Fahrzeug-Service
     * @Parameter int kunde_Id, Kostenvorschlag kostenvorschlag
     * @return Response
     */
    public Response sendKostenvorschlag(int kunde_Id, Kostenvorschlag kostenvorschlag) {
        try {
            return Response.ok("sent Kostenvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to send Kostenvorschlag").build();
        }
    }

    /**
     * Kunde akzeptiert den Kostenvorschlag
     * @Parameter int kostenVorschlag_Id, int kunde_Id
     * @return Response
     */
    public Response acceptKostenvorschlag(int kostenVorschlag_Id, int kunde_Id) {
        try {
            return Response.ok("accepted Kostenvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to accept Kostenvorschlag").build();
        }
    }

    /**
     * erstellt den Kostenvorschlag für einen Kunden
     * @Parameter double kosten, Kunde kunde_Id
     * @return Response
     */
    public Response createKostenvorschlag(double kosten, Kunde kunde_Id) {
        try {
            return Response.ok("created Kostenvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to create Kostenvorschlag").build();
        }
    }

    /**
     * Der Verwalter schickt einem bestimmten Kunden Terminvorschläge; Die Fahrzeuginformation bekommt
     * der Verwalter vom zugesendeten Terminanfrage
     * @Parameter int Kunde_Id, List<TerminVorschlag> terminVorschlagList
     * @return Response
     */
    public Response sendTerminvorschlagList(int Kunde_Id, List<TerminVorschlag> terminVorschlagList) {
        try {
            return Response.ok("sent successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to send Terminvorschlag").build();
        }
    }

    /**
     * Der Verwalter erstellt für den Kunden Terminvorschläge
     * @Parameter Date datum, Time uhrzeit, Kunde kunde, Verwalter verwalter
     * @return Response
     */
    public Response createTerminvorschlag(Date datum, Time uhrzeit, Kunde kunde) {
        try {
            return Response.ok("created Terminvorschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to create Terminvorschlag").build();
        }
    }

    /**
     * Der Kunde akzeptiert einen der vorgeschlagenen Termine
     * @Parameter TerminVorschlag acceptedTermin
     * @return Response
     */
    public Response acceptTerminvoschlag() {
        try {
            return Response.ok("accepted Terminvoschlag successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to accept Terminvoschlag").build();
        }
    }

    /**
     * fügt den Termin in die Termin Tabelle ein
     * @Parameter Date datum, Time uhrzeit, TerminStatus status, String notiz, Service service, Kunde kunde
     * @return Response
     */
    public Response createTermin(Date datum, Time uhrzeit, TerminStatus status, String notiz, Service service, Kunde kunde) {
        try {
            return Response.ok("created Termin successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to create Termin").build();
        }
    }

    /**
     * ausleihen von einem Leihauto bei einer großer Reparatur
     * @Parameter Date verleihDatum, int verleihauto_Id
     * @return Response
     */
    public Response ausleihen(Date verleihDatum, Date rueckgabeDatum, int verleihauto_Id) {
        try {
            return Response.ok("ausleihen successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to ausleihen").build();
        }
    }

    /**
     * verleihauto zurückgeben
     * @Parameter Date rueckgabeDatum, int verleihauto_Id
     * @return Response
     */
    public Response zurueckgeben(Date rueckgabeDatum, int verleihauto_Id) {
        try {
            return Response.ok("zurueckgeben successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to zurueckgeben").build();
        }
    }

    /**
     * löscht einen bestimmten Termin
     * @Parameter int terminId
     * @return Response
     */
    public Response deleteTerminById(int terminId) {
        try {
            return Response.ok("deleted Termin successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to delete Termin").build();
        }
    }

    /**
     * Aktualisiert den Status eines bestimmten Termins
     * @Parameter Terminstatus terminStatus
     * @return Response
     */
    public Response updateTerminstatus(TerminStatus terminStatus) {
        try {
            return Response.ok("updated Termin successfully").build();
        } catch (Exception e) {
            return Response.status(422).entity("failed to update Termin").build();
        }
    }

    /**
     * Findet den Fahrzeug mit dem gegebenen Kennzeichen
     * @Parameter String fahrzeug_Id
     * @return Fahrzeug
     */
    public Fahrzeug findFahrzeugById(String fahrzeug_Id) {
        return null;
    }

    /**
     * Findet den Service mit der gebebenen Id
     * @Parameter int service_Id
     * @return Service
     */
    public Service findServiceById(int service_Id) {
        return null;
    }

    /**
     * Findet den Kunden mit der gegebenen Id
     * @Parameter int kunde_Id
     * @return Kunde
     */
    public Kunde findKundeById(int kunde_Id) {
        return null;
    }




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
