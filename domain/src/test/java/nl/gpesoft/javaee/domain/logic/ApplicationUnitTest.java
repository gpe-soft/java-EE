package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.exception.DeveloperMustBeAnAdultException;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;
import nl.gpesoft.javaee.persistence.adapter.mock.PersistenceRepositoryMockAdapter;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationUnitTest {

    private Developer developerAdult;

    private Developer developerNotAnAdult;

    Date dateOfBirth;

    private Application application;

    private PersistenceRepository persistenceMockRepository = new PersistenceRepositoryMockAdapter();

    @Before
    public void setup() {
        application = new Application(persistenceMockRepository);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            dateOfBirth = simpleDateFormat.parse("01-01-1900");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        developerAdult = new Developer();
        developerAdult.setDateOfBirth(dateOfBirth);

        developerNotAnAdult = new Developer();
        developerNotAnAdult.setDateOfBirth(new Date());
    }

    @Test(expected = DeveloperMustBeAnAdultException.class)
    public void testAddDeveloperNotAnAdult() throws DeveloperMustBeAnAdultException {
        application.addDeveloper(developerNotAnAdult);
    }

    @Test
    public void testAddDeveloperIsAdult() throws DeveloperMustBeAnAdultException {
        application.addDeveloper(developerAdult);
    }
}