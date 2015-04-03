package ua.nikiforov.main;

/**
 * @author Sergey Nikiforov
 */
public class MultiplyWithNoMultiply {
    public static long multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        long res = 0;
        if (b < 0) {
            if (a < 0)
                a = ~a + 1;
            else
                a = ~(a - 1);
            b = ~b + 1;
        }
        while (b > 0) {
            if ((b & 1) != 0) {
                res += a;
            }
            b >>= 1;
            a <<= 1;
        }
        return res;
    }
}
