package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.Repository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Application {

    @Inject
    public Repository repositoryAdapter;

    public void run() {
        Developer developer = new Developer();
        developer.setInitials("A.G.");
        developer.setSurname("Peterse");
        this.repositoryAdapter.addDeveloper(developer);
    }
}