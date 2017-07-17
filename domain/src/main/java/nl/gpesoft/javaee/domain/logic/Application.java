package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Application {

    @Inject
    public PersistenceRepository persistenceRepositoryAdapter;

    public void run() {
        Developer developer = new Developer();
        developer.setInitials("A.G.");
        developer.setSurname("Peterse");
        persistenceRepositoryAdapter.addDeveloper(developer);
    }
}