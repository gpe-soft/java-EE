package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperEmailAddresEmptyException;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.exception.EmailAddressInvalidException;
import nl.gpesoft.javaee.domain.port.notify.NotificationRepository;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;
import nl.gpesoft.javaee.persistence.adapter.mock.PersistenceRepositoryMockAdapter;
import nl.gpesoft.javaee.service.notify.adapter.mock.NotificationMockAdapter;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ApplicationUnitTest {

    private Developer developerAdult;

    private Developer developerNotAnAdult;

    private Developer developerWithEmptyEmailAddress;

    private Developer developerWithInvalidEmailAddress;

    Date dateOfBirth;

    private Application application;

    private PersistenceRepository persistenceMockRepository = new PersistenceRepositoryMockAdapter();

    private NotificationRepository notifyMockRepository = new NotificationMockAdapter();

    @Before
    public void setup() {
        application = new Application(persistenceMockRepository, notifyMockRepository);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            dateOfBirth = simpleDateFormat.parse("01-01-1900");
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        developerAdult = new Developer();
        developerAdult.setDateOfBirth(dateOfBirth);
        developerAdult.setEmailAddress("gpeterse@planet.nl");

        developerNotAnAdult = new Developer();
        developerNotAnAdult.setDateOfBirth(new Date());
        developerNotAnAdult.setEmailAddress("gpeterse@planet.nl");

        developerWithEmptyEmailAddress = new Developer();
        developerWithEmptyEmailAddress.setDateOfBirth(dateOfBirth);
        developerWithEmptyEmailAddress.setEmailAddress("");

        developerWithInvalidEmailAddress = new Developer();
        developerWithInvalidEmailAddress.setDateOfBirth(dateOfBirth);
        developerWithInvalidEmailAddress.setEmailAddress("a");

    }

    @Test(expected = DeveloperMustBeAnAdultException.class)
    public void testAddDeveloperNotAnAdult() throws DeveloperMustBeAnAdultException, DeveloperEmailAddresEmptyException, EmailAddressInvalidException {
        application.registerDeveloper(developerNotAnAdult);
    }

    @Test
    public void testAddDeveloperIsAdult() throws DeveloperMustBeAnAdultException, DeveloperEmailAddresEmptyException, EmailAddressInvalidException {
        application.registerDeveloper(developerAdult);
        assertTrue(application.getDevelopers().size() == 1);
    }

    @Test(expected = DeveloperEmailAddresEmptyException.class)
    public void testAddDeveloperWithEmptyEmailAddress() throws DeveloperMustBeAnAdultException, DeveloperEmailAddresEmptyException, EmailAddressInvalidException {
        application.registerDeveloper(developerWithEmptyEmailAddress);
    }

    @Test(expected = EmailAddressInvalidException.class)
    public void testAddDeveloperWithInvalidEmailAddress() throws DeveloperMustBeAnAdultException, DeveloperEmailAddresEmptyException, EmailAddressInvalidException {
        application.registerDeveloper(developerWithInvalidEmailAddress);
    }
}