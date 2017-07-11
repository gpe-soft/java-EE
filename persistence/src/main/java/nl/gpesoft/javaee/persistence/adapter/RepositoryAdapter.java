package nl.gpesoft.javaee.persistence.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.Repository;

import javax.ejb.Singleton;

@Singleton
public class RepositoryAdapter implements Repository {

    public RepositoryAdapter() {
        System.out.println("construction of repositoryAdapter");
    }

    public void addDeveloper(Developer developer) {
        System.out.println("Adding developer: " + developer.getInitials() + " " + developer.getSurname());
    }
}