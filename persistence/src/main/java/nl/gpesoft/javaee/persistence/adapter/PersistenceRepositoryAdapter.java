package nl.gpesoft.javaee.persistence.adapter;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.PersistenceRepository;
import nl.gpesoft.javaee.persistence.dao.DeveloperDao;

import javax.inject.Inject;
import java.util.List;

public class PersistenceRepositoryAdapter implements PersistenceRepository {

    @Inject
    DeveloperDao developerDao;

    @Override
    public void addDeveloper(Developer developer) {
        developerDao.addDeveloper(developer);
    }

    @Override
    public List<Developer> getDevelopers() {
        return developerDao.getDevelopers();
    }
}