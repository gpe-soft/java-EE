package nl.gpesoft.javaee.domain.port.service;

import javax.ws.rs.core.Response;

public interface ServiceRepository {

    Response addDeveloper();

    Response getDevelopers();

}