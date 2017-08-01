package nl.gpesoft.javaee.persistence.adapter.mock;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import java.util.ArrayList;
import java.util.List;

public class PersistenceRepositoryMockAdapter implements PersistenceRepository {

    private List<Developer> developerList = new ArrayList<>();

    @Override
    public void addDeveloper(Developer developer) {
        developerList.clear();
        developerList.add(developer);
    }

    @Override
    public List<Developer> getDevelopers() {
        return developerList;
    }
}