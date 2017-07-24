package nl.gpesoft.javaee.persistence.dao;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.persistence.mapper.PersistenceMapper;

import javax.ejb.Stateless;

@Stateless //EJB to let the container manage transactions
public class DeveloperDao extends Dao {

     public void addDeveloper (Developer developer) {
        entityManager.persist(PersistenceMapper.toPersistenceModel(developer));
    }
}