package ua.nikiforov.arrays;

import ua.nikiforov.util.BenchmarkUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Sergey Nikiforov
 */
public class ColsRowsSwap {
    private static final int ROWS = 20000;
    private static final int COLS = 10000;

    public static void initializeArrayBeginsWithColumns() {
        int[][] arr = new int[COLS][ROWS];
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                arr[i][j] = 3;
            }
        }
    }

    public static void initializeArrayBeginsWithRows() {
        int[][] arr = new int[COLS][ROWS];
        for (int j = 0; j < ROWS; j++) {
            for (int i = 0; i < COLS; i++) {
                arr[i][j] = 3;
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BenchmarkUtils.invokeAndCalculateTime(ColsRowsSwap.class, "initializeArrayBeginsWithColumns");
        BenchmarkUtils.invokeAndCalculateTime(ColsRowsSwap.class, "initializeArrayBeginsWithRows");
    }

}
