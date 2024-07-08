package at.htl.boundary;

import at.htl.model.Kunde;
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
    @Path("/kunden")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kunde> getAllKunden() {
        return repository.getAllKunden();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }
}
