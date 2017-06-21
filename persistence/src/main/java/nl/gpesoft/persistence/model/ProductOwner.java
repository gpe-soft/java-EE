package nl.gpesoft.persistence.model;

import nl.gpesoft.persistence.common.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Product owner")
public class ProductOwner extends Employee {
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}