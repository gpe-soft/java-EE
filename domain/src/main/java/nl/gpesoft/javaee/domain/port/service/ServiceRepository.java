package nl.gpesoft.javaee.domain.port.service;

import nl.gpesoft.javaee.domain.entity.Developer;

import java.util.List;

public interface ServiceRepository {

    void addDeveloper(Developer developer);

    List<Developer> getDevelopers();
}