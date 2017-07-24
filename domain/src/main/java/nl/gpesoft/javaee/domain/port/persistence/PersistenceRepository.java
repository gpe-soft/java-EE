package nl.gpesoft.javaee.domain.port.persistence;

import nl.gpesoft.javaee.domain.entity.Developer;

import java.util.List;

public interface PersistenceRepository {

   void addDeveloper(Developer developer);

   List<Developer> getDevelopers();
}