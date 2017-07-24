package nl.gpesoft.javaee.persistence.dao;

import nl.gpesoft.javaee.persistence.model.DeveloperTable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Dao {

    @PersistenceContext(unitName = "person")
    EntityManager entityManager;
}