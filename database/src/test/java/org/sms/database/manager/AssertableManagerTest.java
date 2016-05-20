package org.sms.database.manager;

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

    public void assertDeepEquals(Subject expected, Subject actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDifficultyRating(), actual.getDifficultyRating(), 0.001);
    }

    public void assertDeepEquals(Teacher expected, Teacher actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSurName(), actual.getSurName());
    }

    public <T extends AbstractEntity> void assertDeepEquals(List<T> expected, List<T> actual) {
        assertEquals(expected.size(), actual.size());

        if (expected.size() == 0) {
            return;
        }

        if (expected.get(0) instanceof Teacher) {
            for (int i = 0; i < expected.size(); i++) {
                assertDeepEquals((Teacher) expected.get(i), (Teacher) actual.get(i));
            }
        } else if (expected.get(0) instanceof Subject) {
            for (int i = 0; i < expected.size(); i++) {
                assertDeepEquals((Subject) expected.get(i), (Subject) actual.get(i));
            }
        } else {
            assertTrue("Unknown type of list", false);
        }
    }

}
