package ua.nikiforov.reflection;

import java.lang.reflect.Field;

/**
 * @author Sergey Nikiforov
 */
class A {
    private String field = "I'm private field";
}

public class B extends A{

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<A> cl = A.class;
        Field field = cl.getDeclaredField("field");
        field.setAccessible(true);
        System.out.println(field.get(cl.newInstance()));
    }
}
