package ua.nikiforov.reflection;

/**
 * @author Sergey Nikiforov
 */
public class ClassForName {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("ua.nikiforov.reflection.Parent");
        aClass.newInstance();
    }
}
