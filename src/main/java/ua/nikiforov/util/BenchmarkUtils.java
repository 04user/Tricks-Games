package ua.nikiforov.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Sergey Nikiforov
 */
public class BenchmarkUtils {
    public static void invokeAndCalculateTime(Class<?> klass, String methodName) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if (klass != null) {
            Object instance = klass.newInstance();
            Method method = klass.getMethod(methodName);

            long startTimer = System.currentTimeMillis();
            method.invoke(instance);
            System.out.printf("Execution of method %s\t\t took time: %d%n", methodName, System.currentTimeMillis() - startTimer);
        }
    }
}
