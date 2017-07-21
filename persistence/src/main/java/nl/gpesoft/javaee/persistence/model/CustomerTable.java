package nl.gpesoft.javaee.persistence.model;

import nl.gpesoft.javaee.persistence.common.Client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Customer")
public class CustomerTable extends Client {
    private int annualRevenue;

    public int getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(int annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}