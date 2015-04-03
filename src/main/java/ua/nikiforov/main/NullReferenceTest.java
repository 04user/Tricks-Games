package ua.nikiforov.main;

import java.io.IOException;

/**
 * @author Sergey Nikiforov
 */
abstract class NullReferenceTest {
    static String hello = "Hello, World!";

    public static void main(String[] args) {
        NullReferenceTest nullReferenceTest = null;
        System.out.println(nullReferenceTest.hello/*<some descriptor>*/);
    }

    abstract void method() throws IllegalArgumentException,IllegalArgumentException,IOException,IOException, NullPointerException;
}
