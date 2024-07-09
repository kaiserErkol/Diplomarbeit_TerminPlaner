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
        return "Hello World";
    }

    @GET
    @Path("/kunden")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kunde> getAllKunden() {
        return repository.getAllKunden();
    }

    @GET
    @Path("/benachrichtigungen")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Benachrichtigung> getAllBenachrichtigung() {
        return repository.getAllBenachrichtigung();
    }

    @GET
    @Path("/fahrzeuge")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fahrzeug> getAllFahrzeuge() {
        return repository.getAllFahrzeug();
    }

    @GET
    @Path("/kostenvorschlaege")
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
    @Path("/services")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> getAllServices() {
        return repository.getAllService();
    }

    @GET
    @Path("/termine")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Termin> getAllTermine() {
        return repository.getAllTermine();
    }

    @GET
    @Path("/verleihautos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Verleihauto> getAllVerleihauto() {
        return repository.getAllVerleihauto();
    }

    @GET
    @Path("/verwalter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Verwalter> getAllVerwalter() {
        return repository.getAllVerwalter();
    }

    @GET
    @Path("/wartungsverlaeufe")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Wartungsverlauf> getAllWartungsverlauf() {
        return repository.getAllWartungsverlauf();
    }


}
