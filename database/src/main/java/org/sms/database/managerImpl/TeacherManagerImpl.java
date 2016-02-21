package org.sms.database.managerImpl;

import org.sms.database.entity.Teacher;
import org.sms.database.manager.TeacherManager;

import javax.persistence.Query;
import java.util.Collection;

/**
 * @author mhajas
 */
public class TeacherManagerImpl extends AbstractJPAManager<Teacher> implements TeacherManager {

    public TeacherManagerImpl() {
        super(Teacher.class);
    }

    public void createTeacher(Teacher teacher) {
        save(teacher);
    }

    public Collection<Teacher> getAllTeachers() {
        return findAll();
    }

    public void updateTeacher(Teacher teacher) {
        save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return findById(id);
    }

    public void deleteTeacher(Teacher teacher) {
        remove(teacher);
    }

}
