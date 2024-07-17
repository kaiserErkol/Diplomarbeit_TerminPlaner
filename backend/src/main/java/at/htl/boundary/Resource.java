package at.htl.boundary;

import at.htl.model.*;
import at.htl.repository.Repository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class Resource {

    @Inject
    Repository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST\"";
    }

    @GET
    @Path("/kunden")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kunde> getAllKunden() {
        return repository.getAllKunde();
    }

    @GET
    @Path("/feedback")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Feedback> getAllFeedback() {
        return repository.getAllFeedback();
    }

    @GET
    @Path("/fahrzeuge")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fahrzeug> getAllFahrzeuge() {
        return repository.getAllFahrzeug();
    }

    @GET
    @Path("/kostenvorschlag")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kostenvorschlag> getAllKostenvorschlag() {
        return repository.getAllKostenvorschlag();
    }

    @GET
    @Path("/mechaniker")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mechaniker> getAllMechaniker() {
        return repository.getAllMechaniker();
    }

    @GET
    @Path("/reparaturtyp")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reparaturtyp> getAllReparaturtyp() {
        return repository.getAllReparaturtyp();
    }

    @GET
    @Path("/termin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Termin> getAllTermine() {
        return repository.getAllTermine();
    }

    @GET
    @Path("/terminvorschlag")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Terminvorschlag> getAllTerminvorschlag() {
        return repository.getAllTerminvorschlag();
    }

    @GET
    @Path("/leihfahrzeug")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leihfahrzeug> getAllLeihfahrzeug() {
        return repository.getAllLeihfahrzeug();
    }

    @GET
    @Path("/leihvertrag")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leihvertrag> getAllLeihvertrag() {
        return repository.getAllLeihvertrag();
    }

    @GET
    @Path("/verwalter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Verwalter> getAllVerwalter() {
        return repository.getAllVerwalter();
    }

    @GET
    @Path("/reparatur")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reparatur> getAllReparatur() {
        return repository.getAllReparatur();
    }

}
