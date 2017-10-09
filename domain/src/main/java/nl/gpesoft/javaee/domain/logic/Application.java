package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperEmailAddresEmptyException;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.exception.EmailAddressInvalidException;
import nl.gpesoft.javaee.domain.port.notify.NotificationRepository;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    private static final int ADULT_AGE = 18;
    private PersistenceRepository persistenceRepositoryAdapter;
    private NotificationRepository notificationRepositoryAdapter;

    @Inject
    public Application(PersistenceRepository persistenceRepositoryAdapter, NotificationRepository notificationRepositoryAdapter) {
        this.persistenceRepositoryAdapter = persistenceRepositoryAdapter;
        this.notificationRepositoryAdapter = notificationRepositoryAdapter;
    }

    /* Use case 001: Register developer*/
    public void registerDeveloper(Developer developer) throws DeveloperMustBeAnAdultException, DeveloperEmailAddresEmptyException, EmailAddressInvalidException {

        /* User story 001-1: Only adult developers are allowed to register */
        if (!isDeveloperAnAdult(developer)) {
            throw new DeveloperMustBeAnAdultException("Developer must be an adult");
        }

        /* User story 001-2: The e-mail address must be filled */
        if (!hasEmailAddress(developer)) {
            throw new DeveloperEmailAddresEmptyException("E-mail address must be filled");
        }

        /* User story 001-3: E-mail address must be valid */
        if (!isValidEmailAddress(developer.getEmailAddress())) {
            throw new EmailAddressInvalidException("E-mail address is not valid: " + developer.getEmailAddress());
        }

        /* User story 001-4: Register developer */
        addDeveloper(developer);

        /* User story 001-5: Notify developer with an e-mail message */
        notifyDeveloper(developer);
    }

    /* Use case 002: Get registered developers */
    public List<Developer> getDevelopers() {
        return persistenceRepositoryAdapter.getDevelopers();
    }

    private void addDeveloper(Developer developer) throws DeveloperMustBeAnAdultException {
        persistenceRepositoryAdapter.addDeveloper(developer);
    }

    private void notifyDeveloper(Developer developer) {
        notificationRepositoryAdapter.sendNotification(developer);
    }

    private boolean isDeveloperAnAdult(Developer developer) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = developer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthday, today);
        return period.getYears() >= ADULT_AGE;
    }

    private boolean hasEmailAddress(Developer developer) {
        return !developer.getEmailAddress().isEmpty();
    }

    private boolean isValidEmailAddress(String emailAddress) throws EmailAddressInvalidException {
        boolean validEmailAddress;
        try {
            InternetAddress internetAddress = new InternetAddress(emailAddress);
            internetAddress.validate();
            validEmailAddress = true;
        } catch (AddressException addressException) {
            logger.error(addressException.getMessage());
            validEmailAddress = false;
        }
        return validEmailAddress;
    }
}