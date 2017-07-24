package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Address;
import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.entity.Title;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Application {

    @Inject
    public PersistenceRepository persistenceRepositoryAdapter;

    public void addDeveloper() {
        Developer developer = new Developer();
        developer.setTitle(Title.BSC);
        developer.setInitials("T.F.");
        developer.setSurname("Fortran");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            developer.setDateOfBirth(dateFormat.parse("1971-09-01T00:00:00Z"));
            developer.setEmploymentDate(dateFormat.parse("1992-06-13T00:00:00Z"));

        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        developer.setSocialSecurityNumber(999912345678L);
        Address residentialAddress = new Address();
        residentialAddress.setStreet("5th Avenue west");
        residentialAddress.setNumber(154);
        residentialAddress.setPostalCode("YT-67890");
        residentialAddress.setTown("New York");
        developer.setResidentialAddress(residentialAddress);
        developer.setFavouriteProgrammingLanguage("Pascal");
        persistenceRepositoryAdapter.addDeveloper(developer);
    }

    public List<Developer> getDevelopers() {
        return persistenceRepositoryAdapter.getDevelopers();
    }
}