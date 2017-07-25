package nl.gpesoft.javaee.service.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.logic.Application;
import nl.gpesoft.javaee.domain.port.service.ServiceRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public class ServiceRepositorySoapAdapter implements ServiceRepository {

    @Inject
    Application application;

    @Override
    public void addDeveloper(Developer developer) {
        try {
            application.addDeveloper(developer);
        } catch (DeveloperMustBeAnAdultException e) {
 //           e.printStackTrace();
        }
    }

    @Override
    public List<Developer> getDevelopers() {
        return application.getDevelopers();
    }
}