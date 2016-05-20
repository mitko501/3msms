package org.sms.database.manager;

import org.junit.Before;
import org.junit.Test;
import org.sms.database.entity.Subject;
import org.sms.database.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author mhajas
 */
public class SubjectManagerTest extends AssertableManagerTest {

    @Before
    public void setUpEntities() {
        initializeSubjects();
        initializeTeachers();
    }

    @Test
    public void testCreateSubject() {
        subjectManager.createSubject(pb161);

        List<Subject> subjects = new ArrayList<Subject>(subjectManager.getAllSubjects());

        assertEquals(1, subjects.size());

        Subject result = subjects.get(0);
        assertDeepEquals(pb161, result);
        assertDeepEquals(pb161.getTeachers(), result.getTeachers());

        subjectManager.createSubject(pb162);

        subjects = new ArrayList<Subject>(subjectManager.getAllSubjects());

        assertEquals(3, subjects.size());
    }

    @Test
    public void testGetSubjectById() {
        Subject actual = subjectManager.getSubjectById((long) 1);
        assertNull(actual);

        subjectManager.createSubject(pb161);
        actual = subjectManager.getSubjectById(pb161.getId());

        assertDeepEquals(pb161, actual);
        assertDeepEquals(pb161.getTeachers(), actual.getTeachers());
    }

    @Test
    public void testUpdateSubject() {
        subjectManager.createSubject(pb161);

        pb161.setName("Another name");
        subjectManager.updateSubject(pb161);

        Subject actual = subjectManager.getSubjectById(pb161.getId());
        assertDeepEquals(pb161, actual);
        assertDeepEquals(pb161.getTeachers(), actual.getTeachers());
    }

    @Test
    public void testDeleteSubject() {
        subjectManager.createSubject(pb161);
        subjectManager.createSubject(pb162);

        subjectManager.deleteSubject(pb161);

        List<Subject> subjects = new ArrayList<Subject>(subjectManager.getAllSubjects());
        assertEquals(1, subjects.size());
        assertDeepEquals(pb162, subjects.get(0));
        assertDeepEquals(pb162.getTeachers(), subjects.get(0).getTeachers());
    }

    @Test
    public void testCreateSubjectWithTeacher() {
        pb161.addTeacher(mhajas);

        subjectManager.createSubject(pb161);

        Subject actual = subjectManager.getSubjectById(pb161.getId());
        assertDeepEquals(pb161, actual);
        assertDeepEquals(pb161.getTeachers(), actual.getTeachers());

        Teacher actualTeacher = teacherManager.getTeacherById(mhajas.getId());
        mhajas.addSubject(pb161);
        assertDeepEquals(mhajas, actualTeacher);
        assertDeepEquals(mhajas.getSubjects(), actualTeacher.getSubjects());
    }
}