package nl.gpesoft.javaee.persistence.common;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Client extends Person {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}