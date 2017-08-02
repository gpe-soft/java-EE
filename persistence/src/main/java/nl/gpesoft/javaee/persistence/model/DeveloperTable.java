package nl.gpesoft.javaee.persistence.model;

import nl.gpesoft.javaee.persistence.common.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value = "Developer")
@XmlRootElement
public class DeveloperTable extends Employee {
    private String favouriteProgrammingLanguage;

    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }

    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }
}