package ua.nikiforov.main.npe;

/**
 * @author Sergey Nikiforov
 */
public class BoxingNPE {
    private static Boolean b1, b2;

    public static void main (String[] args) {
        System.out.println(b1);
        if (b1 || !b2 || !b1 || b2) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
