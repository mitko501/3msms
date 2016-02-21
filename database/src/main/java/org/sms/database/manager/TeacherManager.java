package org.sms.database.manager;

import org.sms.database.entity.Teacher;

import java.util.Collection;

/**
 * @author mhajas
 */
public interface TeacherManager {

    void createTeacher(Teacher teacher);

    Collection<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);
}
