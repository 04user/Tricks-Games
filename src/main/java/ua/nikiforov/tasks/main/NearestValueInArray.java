package ua.nikiforov.tasks.main;

import static java.lang.Math.*;

/**
 * @author Sergey Nikiforov
 */
public class NearestValueInArray {
    /**
     * Finding the nearest value for specified candidate in array.
     *
     * @param array     where search doing.
     * @param candidate nearest for whom searched.
     */
    public static int searchNearestValue(final int[] array, int candidate) {
        int nearest = Integer.MAX_VALUE;

        for (int element : array) {
            if (abs(candidate - nearest) > abs(candidate - element)) {
                nearest = element;
            }
        }

        return nearest;
    }
}
