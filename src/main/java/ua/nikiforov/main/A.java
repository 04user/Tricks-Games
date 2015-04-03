package ua.nikiforov.main;

import java.util.*;

/**
 * @author Sergey Nikiforov
 */
public class A {
    public String name;

    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Object o){
        if(o instanceof A){
            return name.equals( ((A)o).name );
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Map<A, Integer> map = new HashMap<>();

        A a1 = new A();
        a1.name = "one";
        map.put(a1, 1);
        a1.name = "two";

        A a2 = new A();
        a2.name = "one";

        System.out.println(map.get(a1));
        System.out.println(map.get(a2));
        Set<A> as = map.keySet();
        System.out.println(Arrays.toString(as.toArray()));
/*
        for (Object o : map.keySet()) {
            System.out.println(((A)o).name);
        }
*/
    }
}
