package nl.gpesoft.javaee.domain.port.service;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;

import java.util.List;

public interface ServiceRepository {

    void addDeveloper(Developer developer) throws DeveloperMustBeAnAdultException;

    List<Developer> getDevelopers();
}