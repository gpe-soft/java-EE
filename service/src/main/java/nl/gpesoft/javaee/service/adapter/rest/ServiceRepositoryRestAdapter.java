package nl.gpesoft.javaee.service.adapter.rest;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperEmailAddresEmptyException;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.exception.EmailAddressInvalidException;
import nl.gpesoft.javaee.domain.logic.Application;
import nl.gpesoft.javaee.domain.port.service.ServiceRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


@Path("/start")
public class ServiceRepositoryRestAdapter implements ServiceRepository {

    Logger logger = LoggerFactory.getLogger(ServiceRepositoryRestAdapter.class);

    @Inject
    Application application;

    @POST
    @Path("/developer/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response registerDeveloperRestService(Developer developer) {
        this.registerDeveloper(developer);
        return Response.ok().build();
    }

    @GET
    @Path("/developer/get")
    @Produces("application/json")
    public Response getDevelopersRestService() {
        MDC.put("type service","REST");
        logger.info("getDevelopersRestService");
        MDC.clear();
        return Response.ok(this.getDevelopers()).build();
    }

    @Override
    public void registerDeveloper(Developer developer) {
        try {
            application.registerDeveloper(developer);
        } catch (DeveloperMustBeAnAdultException developerMustBeAnAdultException) {
            logger.error(developerMustBeAnAdultException.getMessage());
        } catch (DeveloperEmailAddresEmptyException developerEmailAddressEmptyException) {
            logger.error(developerEmailAddressEmptyException.getMessage());
        } catch (EmailAddressInvalidException emailAddressInvalidException) {
            logger.error(emailAddressInvalidException.getMessage());
        }

    }

    @Override
    public List<Developer> getDevelopers() {
        return application.getDevelopers();
    }
}