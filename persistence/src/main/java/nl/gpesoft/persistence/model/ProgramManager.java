package nl.gpesoft.persistence.model;

import nl.gpesoft.persistence.common.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Program manager")
public class ProgramManager extends Employee {
    private String ProgramName;

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String programName) {
        ProgramName = programName;
    }
}