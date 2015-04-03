package ua.nikiforov.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Nikiforov
 */
public class KeyInHashMap {
    volatile int a;

/*
    public static void main(String[] args) {
        Map<byte[], String> map = new HashMap<>();
        map.put(new byte[]{1, 2, 3}, "asd");
        byte[] key2 = {1, 2};
        map.put(key2, "wqe");
        System.out.println(map.get(key2));
    }
*/
static String str = "Value 1";

    static Character c = 'c';

    public static void changeIt(String s) {
        s = "Value 2";
    }

    public void changeIt(char a) {
        a = 'a';
    }

    public static void main(String[] args) {
        KeyInHashMap clazz = new KeyInHashMap();
        char b = 'f';
        clazz.changeIt(b);
        System.out.println(b);
    }
}
