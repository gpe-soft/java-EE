package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

public class Application {

    private PersistenceRepository persistenceRepositoryAdapter;

    @Inject
    public Application(PersistenceRepository persistenceRepositoryAdapter) {
        this.persistenceRepositoryAdapter = persistenceRepositoryAdapter;
    }

    final static int ADULT_AGE = 18;

    public void addDeveloper(Developer developer) throws DeveloperMustBeAnAdultException {
        if (!isDeveloperAnAdult(developer)) {
            throw new DeveloperMustBeAnAdultException("Developer must be an adult");
        }
        persistenceRepositoryAdapter.addDeveloper(developer);
    }


    public List<Developer> getDevelopers() {
        return persistenceRepositoryAdapter.getDevelopers();
    }

    private boolean isDeveloperAnAdult(Developer developer) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = developer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthday, today);
        return period.getYears() >= ADULT_AGE;
    }
}