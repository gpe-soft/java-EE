package nl.gpesoft.javaee.domain.logic;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.persistence.Repository;
import nl.gpesoft.javaee.persistence.adapter.RepositoryAdapter;

public class Application {
    public static void main(String[] args) {
        Developer developer = new Developer();
        Repository persistencePort = new RepositoryAdapter();

    }
}