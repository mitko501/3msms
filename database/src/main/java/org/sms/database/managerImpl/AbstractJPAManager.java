package org.sms.database.managerImpl;

import org.sms.database.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

/**
 * @author mhajas
 */
abstract public class AbstractJPAManager<T extends AbstractEntity> {
    protected EntityManager entityManager;
    private Class<T> type;

    AbstractJPAManager(Class<T> type) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("3msmsPU");
        entityManager = emFactory.createEntityManager();
        this.type = type;
    }

    public void save(T entity) {
        entityManager.getTransaction().begin();
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.getTransaction().commit();
    }

    public Collection<T> findAll() {
        Query query = entityManager.createQuery("SELECT t FROM " + type.getName() + " t");
        return (Collection<T>) query.getResultList();
    }

    public T findById(Long id) {
        return entityManager.find(type, id);
    }

    public void remove(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
