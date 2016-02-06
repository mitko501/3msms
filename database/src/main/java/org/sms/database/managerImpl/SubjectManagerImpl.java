package org.sms.database.managerImpl;

import org.sms.database.entity.Subject;
import org.sms.database.manager.SubjectManager;

import javax.persistence.Query;
import java.util.Collection;

/**
 * @author mhajas
 */
public class SubjectManagerImpl extends AbstractJPAManager implements SubjectManager {

    //TODO: check subject
    public void createSubject(Subject subject) {
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.getTransaction().commit();
    }

    public Collection<Subject> getAllSubjects() {
        Query query = entityManager.createQuery("Select s from Subject s");
        return (Collection<Subject>) query.getResultList();
    }

    public Subject getSubjectById(long id) {
        return entityManager.find(Subject.class, id);
    }

    //TODO: check subject
    public void updateSubject(Subject subject) {
        entityManager.merge(subject);
    }

    //TODO: check subject
    public void deleteSubject(Subject subject) {
        entityManager.getTransaction().begin();
        entityManager.remove(subject);
        entityManager.getTransaction().commit();
    }
}
