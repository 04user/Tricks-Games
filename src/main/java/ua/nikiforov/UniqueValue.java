package ua.nikiforov;

/**
 * @author Sergey Nikiforov
 */
public class UniqueValue {
    public static int findUniqueValue(int[] arr) {
        int value = 0;
        for (int elem : arr) {
            value ^= elem;
        }
        return value;
    }

}
