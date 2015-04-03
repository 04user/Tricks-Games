package ua.nikiforov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergey Nikiforov
 */
public class WooWoo {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 2, 5, 7};
        HashSet<Integer> set = Arrays.stream(array).parallel().sorted().boxed().collect(HashSet::new, HashSet::add, HashSet::addAll);

        for (Object o : set) {
            System.out.println(o);
        }
//        set.stream().forEach(System.out::println);
    }
}
