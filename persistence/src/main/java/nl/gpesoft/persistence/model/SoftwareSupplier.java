package nl.gpesoft.persistence.model;

import nl.gpesoft.persistence.common.Client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Software supplier")
public class SoftwareSupplier extends Client {
    private String softwarePackage;

    public String getSoftwarePackage() {
        return softwarePackage;
    }

    public void setSoftwarePackage(String softwarePackage) {
        this.softwarePackage = softwarePackage;
    }
}