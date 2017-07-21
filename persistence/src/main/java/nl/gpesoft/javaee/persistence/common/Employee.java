package nl.gpesoft.javaee.persistence.common;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Employee extends PersonTable {
    private Date employmentDate;

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }
}