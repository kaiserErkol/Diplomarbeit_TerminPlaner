package at.htl.boundary;

import at.htl.repository.Repository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Termin")
public class Resource {

    @Inject
    Repository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllTermine")
    public Response getAllTermine() {
        return Response.ok().entity(repository.getAllTermine()).build();
    }
}
