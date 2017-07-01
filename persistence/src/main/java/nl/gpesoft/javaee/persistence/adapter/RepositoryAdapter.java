package nl.gpesoft.javaee.persistence.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.Repository;

public class RepositoryAdapter implements Repository {
    public void addDeveloper(Developer developer) {
        System.out.println("Adding developer");
    }
}