package ua.nikiforov;

/**
 * @author Sergey Nikiforov
 */
public class BitsShift {
    public static void main(String[] args) {
//        int x = 0b10101111_11111111_11111111_11110101;
        int x = -7;
//        System.out.println(Integer.toBinaryString(x));
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
//        System.out.println(Integer.toBinaryString(x));
    }
}
