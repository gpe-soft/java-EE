package nl.gpesoft.javaee.domain.port.persistence;

import nl.gpesoft.javaee.domain.entity.Developer;

public interface PersistenceRepository {

   void addDeveloper(Developer developer);
}