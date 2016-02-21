package org.sms.database.managerImpl;

import org.sms.database.entity.Subject;
import org.sms.database.manager.SubjectManager;

import javax.persistence.Query;
import java.util.Collection;

/**
 * @author mhajas
 */
public class SubjectManagerImpl extends AbstractJPAManager<Subject> implements SubjectManager {

    public SubjectManagerImpl() {
        super(Subject.class);
    }
    //TODO: check subject
    public void createSubject(Subject subject) {
        save(subject);
    }

    public Collection<Subject> getAllSubjects() {
        return findAll();
    }

    public Subject getSubjectById(Long id) {
        return findById(id);
    }

    //TODO: check subject
    public void updateSubject(Subject subject) {
        save(subject);
    }

    //TODO: check subject
    public void deleteSubject(Subject subject) {
        remove(subject);
    }
}
