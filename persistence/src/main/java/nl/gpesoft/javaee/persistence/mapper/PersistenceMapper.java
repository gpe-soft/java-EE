package nl.gpesoft.javaee.persistence.mapper;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.persistence.model.DeveloperTable;

public class PersistenceMapper {

    public static DeveloperTable toPersistenceModel(Developer developer) {
        DeveloperTable developerTable = new DeveloperTable();
        developerTable.setInitials(developer.getInitials());
        developerTable.setTitle(developer.getTitle().title());
        return developerTable;
    }
}
