package ua.nikiforov.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 http://stackoverflow.com/questions/3301635/change-private-static-final-field-using-java-reflection
*/
public class EverythingIsTrue {
    public static void main(String args[]) throws Exception {
        setFinalStatic(Boolean.class.getField("FALSE"), true);
        System.out.format("Everything is %s", false); // "Everything is true"
    }

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }
}
