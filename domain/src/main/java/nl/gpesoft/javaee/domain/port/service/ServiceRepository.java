package nl.gpesoft.javaee.domain.port.service;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperEmailAddresEmptyException;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.exception.EmailAddressInvalidException;

import java.util.List;

public interface ServiceRepository {

    void registerDeveloper(Developer developer) throws DeveloperMustBeAnAdultException, DeveloperEmailAddresEmptyException, EmailAddressInvalidException;

    List<Developer> getDevelopers();
}