package nl.gpesoft.javaee.persistence.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import java.util.List;

public class PersistenceRepositoryAdapter implements PersistenceRepository {

    @Override
    public void addDeveloper(Developer developer) {

    }

    @Override
    public List<Developer> getListOfDevelopers() {
        return null;
    }
}