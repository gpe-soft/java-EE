package nl.gpesoft.javaee.service.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.logic.Application;
import nl.gpesoft.javaee.domain.port.service.ServiceRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/start")
public class ServiceRepositoryRestAdapter implements ServiceRepository {

    @Inject
    Application application;

    @POST
    @Path("/developer/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addDeveloperRestService(Developer developer) {
        this.addDeveloper(developer);
        return Response.ok().build();
    }

    @GET
    @Path("/developer/get")
    @Produces("application/json")
    public Response getDevelopersRestService() {
        return Response.ok(this.getDevelopers()).build();
    }

    @Override
    public void addDeveloper(Developer developer) {
        try {
            application.addDeveloper(developer);
        } catch (DeveloperMustBeAnAdultException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Developer> getDevelopers() {
        return application.getDevelopers();
    }
}