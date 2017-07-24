package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.entity.Title;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import javax.inject.Inject;

public class Application {

    @Inject
    public PersistenceRepository persistenceRepositoryAdapter;

    public void run() {
        Developer developer = new Developer();
        developer.setTitle(Title.BSC);
        developer.setInitials("A.G.");
        developer.setSurname("Peterse");
        persistenceRepositoryAdapter.addDeveloper(developer);
    }
}