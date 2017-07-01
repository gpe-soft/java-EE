package nl.gpesoft.javaee.domain.port.persistence;

import nl.gpesoft.javaee.domain.entity.Developer;

public interface Repository {

    void addDeveloper(Developer developer);
}