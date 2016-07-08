package org.sms.database.manager;

import org.slf4j.Logger;
import org.sms.database.entity.AbstractEntity;
import org.sms.database.entity.Subject;
import org.sms.database.entity.Teacher;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author mhajas
 */
public class AssertableManagerTest extends AbstractManagerTest {

    protected void assertDeepEquals(Subject expected, Subject actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDifficultyRating(), actual.getDifficultyRating(), 0.001);
    }

    protected void assertDeepEquals(Teacher expected, Teacher actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSurName(), actual.getSurName());
    }

    protected void assertDeepEquals(AbstractEntity expected, AbstractEntity actual) {
        if (expected instanceof Teacher) {
            assertDeepEquals((Teacher) expected, (Teacher) actual);
        } else if (expected instanceof Subject) {
            assertDeepEquals((Subject) expected, (Subject) actual);
        } else {
            log.error("Unknown entity " + expected);
            assertTrue(false);
        }
    }

    protected  <T extends AbstractEntity> void assertDeepEquals(List<T> expected, List<T> actual) {
        assertEquals(expected.size(), actual.size());

        if (expected.size() == 0) {
            return;
        }

        for (int i = 0; i < expected.size(); i++) {
            assertDeepEquals(expected.get(i), actual.get(i));
        }

    }


}
