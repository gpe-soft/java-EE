package nl.gpesoft.javaee.persistence.dao;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.persistence.mapper.PersistenceMapper;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless //EJB to let the container manage transactions
public class DeveloperDao extends Dao {

    public void addDeveloper(Developer developer) {
        entityManager.persist(PersistenceMapper.toPersistenceModelDeveloper(developer));
    }

    public List<Developer> getDevelopers() {
        List<Developer> listDevelopers = entityManager.createQuery("SELECT d FROM DeveloperTable d").getResultList();
        return listDevelopers;
    }
}