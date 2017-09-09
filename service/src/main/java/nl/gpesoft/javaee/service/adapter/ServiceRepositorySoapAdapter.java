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
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ServiceRepositorySoapAdapter implements ServiceRepository {

    Logger logger = LoggerFactory.getLogger(ServiceRepositorySoapAdapter.class);

    @Inject
    Application application;

    public ServiceRepositorySoapAdapter() {
    }

    @Override
    @WebMethod
    public void addDeveloper(Developer developer) throws DeveloperMustBeAnAdultException {
        try {
            application.addDeveloper(developer);
        } catch (DeveloperMustBeAnAdultException developerMustBeAnAdultException) {
            logger.error(developerMustBeAnAdultException.getMessage());
            throw developerMustBeAnAdultException;
        }
    }

    @Override
    @WebMethod
    public List<Developer> getDevelopers() {
        logger.info("soap getting list of developers");
        return application.getDevelopers();
    }
}