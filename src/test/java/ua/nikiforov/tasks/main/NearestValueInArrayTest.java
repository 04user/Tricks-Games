package ua.nikiforov.tasks.main;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static ua.nikiforov.tasks.main.NearestValueInArray.*;

/**
 * @author Sergey Nikiforov
 */
public class NearestValueInArrayTest {
    @Test
    public void plainTest() {
        int[] array = new int[]{1, 2, 4, 10, 17};
        int e = 7;

        int nearestValue = searchNearestValue(array, e);

        assertEquals(nearestValue, 4);
    }

    @Test
    public void whenArrayHaveMaxNumbers1() {
        int[] array = new int[]{1, 2, 4, 10, Integer.MAX_VALUE};
        int e = 9;

        int nearestValue = searchNearestValue(array, e);

        assertEquals(nearestValue, 10);
    }

    @Test
    public void whenArrayHaveMaxNumbers2() {
        int[] array = new int[]{Integer.MAX_VALUE, 1, 13, 4, 1, Integer.MAX_VALUE, Integer.MAX_VALUE - 3};
        int e = Integer.MAX_VALUE - 1;

        int nearestValue = searchNearestValue(array, e);

        assertEquals(nearestValue, Integer.MAX_VALUE);
    }
}
