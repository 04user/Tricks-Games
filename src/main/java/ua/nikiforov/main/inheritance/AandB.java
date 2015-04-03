package ua.nikiforov.main.inheritance;

/**
 * @author Sergey Nikiforov
 */
public class AandB {
    class A {
        String str = "ab";

        A() {
            printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }

    class B extends A {
        String str = "abc";

        void printLength() {
            System.out.println(str.length());
        }
    }

    public static void main(String[] args) {
        new AandB().new B();
    }
}
