package nl.gpesoft.javaee.persistence.mapper;

import nl.gpesoft.javaee.domain.entity.Address;
import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.entity.Title;
import nl.gpesoft.javaee.persistence.common.AddressTable;
import nl.gpesoft.javaee.persistence.model.DeveloperTable;

public class PersistenceMapper {

    public static DeveloperTable toPersistenceModelDeveloper(Developer developer) {
        DeveloperTable developerTable = new DeveloperTable();
        developerTable.setTitle(developer.getTitle().title());
        developerTable.setInitials(developer.getInitials());
        developerTable.setSurname(developer.getSurname());
        developerTable.setEmailAddress(developer.getEmailAddress());
        developerTable.setDateOfBirth(developer.getDateOfBirth());
        developerTable.setSocialSecurityNumber(developer.getSocialSecurityNumber());
        developerTable.setResidentialAddress(toPersistenceModelAddress(developer.getResidentialAddress()));
        developerTable.setEmploymentDate(developer.getEmploymentDate());
        developerTable.setFavouriteProgrammingLanguage(developer.getFavouriteProgrammingLanguage());
        return developerTable;
    }

    public static Developer toDomainModelDeveloper(DeveloperTable developerTable) {
        Developer developer = new Developer();
        developer.setTitle(Title.of(developerTable.getTitle()));
        developer.setInitials(developerTable.getInitials());
        developer.setSurname(developerTable.getSurname());
        developer.setEmailAddress(developerTable.getEmailAddress());
        developer.setDateOfBirth(developerTable.getDateOfBirth());
        developer.setSocialSecurityNumber(developerTable.getSocialSecurityNumber());
        developer.setResidentialAddress(toDomainModelAddress(developerTable.getResidentialAddress()));
        developer.setEmploymentDate(developerTable.getEmploymentDate());
        developer.setFavouriteProgrammingLanguage(developerTable.getFavouriteProgrammingLanguage());
        return developer;
    }

    private static AddressTable toPersistenceModelAddress(Address address) {
        AddressTable addressTable = new AddressTable();
        addressTable.setStreet(address.getStreet());
        addressTable.setNumber(address.getNumber());
        addressTable.setPostalCode(address.getPostalCode());
        addressTable.setTown(address.getTown());
        return addressTable;
    }

    private static Address toDomainModelAddress(AddressTable addressTable) {
        Address address = new Address();
        address.setStreet(addressTable.getStreet());
        address.setNumber(addressTable.getNumber());
        address.setPostalCode(addressTable.getPostalCode());
        address.setTown(addressTable.getTown());
        return address;
    }
}