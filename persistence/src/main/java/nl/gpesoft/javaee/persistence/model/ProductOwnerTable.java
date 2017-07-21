package nl.gpesoft.javaee.persistence.model;

import nl.gpesoft.javaee.persistence.common.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Product owner")
public class ProductOwnerTable extends Employee {
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}