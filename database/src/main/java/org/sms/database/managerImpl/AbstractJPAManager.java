package org.sms.database.managerImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author mhajas
 */
abstract public class AbstractJPAManager {
    protected EntityManager entityManager;

    AbstractJPAManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("3msmsPU");
        entityManager = emFactory.createEntityManager();
    }
}
