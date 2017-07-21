package nl.gpesoft.javaee.persistence.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

public class PersistenceRepositoryAdapter implements PersistenceRepository {

    public PersistenceRepositoryAdapter() {
        System.out.println("construction of persistenceRepositoryAdapter");
    }

    public void addDeveloper(Developer developer) {
        System.out.println("Adding developer: " + developer.getInitials() + " " + developer.getSurname());
    }
}