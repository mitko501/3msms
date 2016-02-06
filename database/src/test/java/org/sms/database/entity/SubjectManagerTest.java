package org.sms.database.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sms.database.manager.SubjectManager;
import org.sms.database.managerImpl.SubjectManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author mhajas
 */
public class SubjectManagerTest {

    private SubjectManager subjectManager = new SubjectManagerImpl();
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("3msmsPU");

    private Subject pb161;
    private Subject pb162;

    @After
    public void clearDatabase() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM SUB_TECH").executeUpdate();
        em.createNativeQuery("DELETE FROM TEACHER").executeUpdate();
        em.createNativeQuery("DELETE FROM SUBJECT").executeUpdate();
        em.getTransaction().commit();
    }

    @Before
    public void setUp() {
        pb161 = new Subject("PB161", "C++", 2.5);
        pb162 = new Subject("PB162", "Java", 2.4);
    }

    @Test
    public void testCreateSubject() {
        subjectManager.createSubject(pb161);

        List<Subject> subjects = new ArrayList<Subject>(subjectManager.getAllSubjects());

        assertEquals(1, subjects.size());

        Subject result = subjects.get(0);
        assertDeepEquals(pb161, result);

        subjectManager.createSubject(pb162);

        subjects = new ArrayList<Subject>(subjectManager.getAllSubjects());

        assertEquals(2, subjects.size());
    }

    @Test
    public void testGetSubjectById() {
        Subject actual = subjectManager.getSubjectById(0);
        assertNull(actual);

        subjectManager.createSubject(pb161);
        actual = subjectManager.getSubjectById(pb161.getId());

        assertDeepEquals(pb161, actual);
    }

    @Test
    public void testUpdateSubject() {
        subjectManager.createSubject(pb161);

        pb161.setName("Another name");
        subjectManager.updateSubject(pb161);

        Subject actual = subjectManager.getSubjectById(pb161.getId());
        assertDeepEquals(pb161, actual);
    }

    @Test
    public void testDeleteSubject() {
        subjectManager.createSubject(pb161);
        subjectManager.createSubject(pb162);

        subjectManager.deleteSubject(pb161);

        List<Subject> subjects = new ArrayList<Subject>(subjectManager.getAllSubjects());
        assertEquals(1, subjects.size());

        assertDeepEquals(pb162, subjects.get(0));
    }

    private void assertDeepEquals(Subject expected, Subject actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDifficultyRating(), actual.getDifficultyRating(), 0.001);
        assertEquals(expected.getTeachers(), actual.getTeachers());
    }

}