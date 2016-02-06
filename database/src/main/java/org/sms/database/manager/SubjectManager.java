package org.sms.database.manager;

import org.sms.database.entity.Subject;

import java.util.Collection;

/**
 * @author mhajas
 */
public interface SubjectManager {

    void createSubject(Subject subject);

    Collection<Subject> getAllSubjects();

    Subject getSubjectById(long id);

    void updateSubject(Subject subject);

    void deleteSubject(Subject subject);
}
