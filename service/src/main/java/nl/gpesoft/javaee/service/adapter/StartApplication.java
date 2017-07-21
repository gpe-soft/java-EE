package nl.gpesoft.javaee.service.adapter;

import nl.gpesoft.javaee.domain.logic.Application;
import nl.gpesoft.javaee.domain.port.service.ServiceRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/start")
public class StartApplication implements ServiceRepository {

    @Inject
    Application application;

    @GET
    @Path("/application")
    public void startApplication() {
        application.run();
    }
}