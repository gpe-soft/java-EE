package nl.gpesoft.javaee.service.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.logic.Application;
import nl.gpesoft.javaee.domain.port.service.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ServiceRepositorySoapAdapter implements ServiceRepository {

    Logger logger = LoggerFactory.getLogger(ServiceRepositorySoapAdapter.class);

    @Inject
    Application application;

    public ServiceRepositorySoapAdapter() {
    }

    @Override
    @WebMethod
    public void addDeveloper(Developer developer) {
        try {
            application.addDeveloper(developer);
        } catch (DeveloperMustBeAnAdultException developerMustBeAnAdultException) {
            logger.error(developerMustBeAnAdultException.getMessage());
        }
    }

    @Override
    @WebMethod
    public List<Developer> getDevelopers() {
        System.out.println("soap getting developers");
        return application.getDevelopers();
    }
}