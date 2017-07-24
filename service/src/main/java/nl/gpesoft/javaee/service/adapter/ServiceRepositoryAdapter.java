package nl.gpesoft.javaee.service.adapter;

import nl.gpesoft.javaee.domain.logic.Application;
import nl.gpesoft.javaee.domain.port.service.ServiceRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/start")
public class ServiceRepositoryAdapter implements ServiceRepository {

    @Inject
    Application application;

    @GET
    @Path("/developer/add")
    public Response addDeveloper() {
        application.addDeveloper();
        return Response.ok().build();
    }

    @GET
    @Path("/developer/get")
    @Produces("application/json")
    public Response getDevelopers() {
        return Response.ok(application.getDevelopers()).build();
    }
}