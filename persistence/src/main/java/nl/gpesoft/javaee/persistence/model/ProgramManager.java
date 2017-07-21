package nl.gpesoft.javaee.persistence.model;

import nl.gpesoft.javaee.persistence.common.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Program manager")
public class ProgramManager extends Employee {
    private String programName;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}