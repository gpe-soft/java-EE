package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.port.notify.NotificationRepository;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

public class Application {

    private static final int ADULT_AGE = 18;
    private PersistenceRepository persistenceRepositoryAdapter;
    private NotificationRepository notificationRepositoryAdapter;

    @Inject
    public Application(PersistenceRepository persistenceRepositoryAdapter, NotificationRepository notificationRepositoryAdapter) {
        this.persistenceRepositoryAdapter = persistenceRepositoryAdapter;
        this.notificationRepositoryAdapter = notificationRepositoryAdapter;
    }

    public void addDeveloper(Developer developer) throws DeveloperMustBeAnAdultException {
        if (!isDeveloperAnAdult(developer)) {
            throw new DeveloperMustBeAnAdultException("Developer must be an adult");
        }
        persistenceRepositoryAdapter.addDeveloper(developer);
        notificationRepositoryAdapter.sendNotification(developer);
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