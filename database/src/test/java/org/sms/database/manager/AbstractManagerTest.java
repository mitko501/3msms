package org.sms.database.manager;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sms.database.entity.Subject;
import org.sms.database.entity.Teacher;
import org.sms.database.managerImpl.SubjectManagerImpl;
import org.sms.database.managerImpl.TeacherManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author mhajas
 */
public abstract class AbstractManagerTest {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    protected SubjectManager subjectManager = new SubjectManagerImpl();
    protected TeacherManager teacherManager = new TeacherManagerImpl();

    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("3msmsPU");
    protected EntityManager em = entityManagerFactory.createEntityManager();


    protected Subject pb161;
    protected Subject pb162;

    protected Teacher mhajas;
    protected Teacher mkralik;

    @Before
    public void setUp() {
        em.getTransaction().begin();
    }

    protected void initializeSubjects() {
        pb161 = new Subject("PB161", "C++", 2.5);
        pb162 = new Subject("PB162", "Java", 2.4);
    }

    protected void initializeTeachers() {
        mhajas = new Teacher("Michal", "Hajas");
        mkralik = new Teacher("Matej", "Kralik");
    }

    @After
    public void clearDatabase() {
        em.getTransaction().rollback();
    }

}
