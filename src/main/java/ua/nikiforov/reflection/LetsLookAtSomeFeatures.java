package ua.nikiforov.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Sergey Nikiforov
 */
public class LetsLookAtSomeFeatures {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Parent instance = new Child("Great!");
        Class<? extends Parent> clazz = instance.getClass();

//        System.out.println(Class.forName(clazz.getName()));
//        printModifiers(clazz);
//        whoIsMyParent(clazz);
        printFieldInfo(instance, clazz);

    }

    public static void printFieldInfo(Parent instance, Class<? extends Parent> clazz) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            System.out.printf("Field name: %s%nField type: %s%nValue: %s%n%n", field.getName(), fieldType, field.get(instance));
        }
    }

    public static void whoIsMyParent(Class<? extends Object> clazz) {
        Class<?> superclass = clazz.getSuperclass();
        System.out.println(superclass.toString());
    }

    private static void printModifiers(Class<? extends Object> clazz) {
        int modifiers = clazz.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println("public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println("final");
        }
    }
}
