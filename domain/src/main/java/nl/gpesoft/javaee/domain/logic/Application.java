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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            developer.setDateOfBirth(dateFormat.parse("01/09/1971"));
            developer.setEmploymentDate(dateFormat.parse("07/06/1992"));

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