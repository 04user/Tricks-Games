package ua.nikiforov.main;

/**
 * @author Sergey Nikiforov
 */
public class PostPreIncrement {
    public static void main(String[] args) {
        int i = 5;
        i = ++i + ++i;
        System.out.println(i);
    }
}
