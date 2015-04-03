package ua.nikiforov.main;

import java.util.HashMap;

/**
 * @author Sergey Nikiforov
 */
public class IfWith2Conditions {
    public static void main(String[] args) {
        String s = "a.sd";
        HashMap<Integer, String> map = new HashMap<>(3);
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");


        int index;
        String value;
        if ((index = s.lastIndexOf(".")) != -1 &&
            (value = map.get(index)) != null) {
            System.out.println(value);
        }
    }
}
