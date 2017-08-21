package nl.gpesoft.javaee.persistence.model;

import nl.gpesoft.javaee.persistence.common.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Developer")
public class DeveloperTable extends Employee {

    public DeveloperTable() {
    }

    private String favouriteProgrammingLanguage;

    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }

    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }
}