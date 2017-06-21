package nl.gpesoft.persistence.model;

import nl.gpesoft.persistence.common.Client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Customer")
public class Customer extends Client {
    private int annualRevenue;

    public int getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(int annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}