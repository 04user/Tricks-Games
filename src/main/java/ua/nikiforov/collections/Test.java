package ua.nikiforov.collections;

import java.util.ArrayList;

/**
 * @author Sergey Nikiforov
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(5);
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");

        ArrayList<String> arrayList2 = new ArrayList<>(5);
        arrayList2.add("one");
        arrayList2.add("two");
        arrayList2.add("three");

        arrayList.removeAll(arrayList2);
        System.out.println(arrayList);


        int oldCapacity = 5;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
    }
}
