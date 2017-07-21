package nl.gpesoft.javaee.persistence.model;

import nl.gpesoft.javaee.persistence.common.Client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Software supplier")
public class SoftwareSupplierTable extends Client {
    private String softwarePackage;

    public String getSoftwarePackage() {
        return softwarePackage;
    }

    public void setSoftwarePackage(String softwarePackage) {
        this.softwarePackage = softwarePackage;
    }
}