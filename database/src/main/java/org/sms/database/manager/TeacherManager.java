package org.sms.database.manager;

import java.util.Collection;

/**
 * @author mhajas
 */
public interface TeacherManager {

    void createTeacher(TeacherManager subject);

    Collection<TeacherManager> getAllTeachers();

    TeacherManager getTeacherById(long id);

    void updateTeacher(TeacherManager subject);

    void deleteTeacher(TeacherManager subject);
}
