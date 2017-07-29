package nl.gpesoft.javaee.persistence.adapter.mock;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;

import java.util.ArrayList;
import java.util.List;

public class PersistenceRepositoryMockAdapter implements PersistenceRepository {

    @Override
    public void addDeveloper(Developer developer) {
    }

    @Override
    public List<Developer> getDevelopers() {
        List<Developer> developerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            developerList.add(new Developer());
        }
        return developerList;
    }
}