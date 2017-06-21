package nl.gpesoft.persistence.common;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Employee extends Person {
    private Date employmentDate;

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }
}