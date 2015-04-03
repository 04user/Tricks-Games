package ua.nikiforov.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Nikiforov
 */
public class FormArrayToList {
    public static void main(String[] args) {
        int[] array =  {1, 2, 3, 4, 5};
        List<Integer> list = null;

//        System.out.println(Arrays.toString(array));
//        List<Object> list = Arrays.asList(array);
//        Collections.addAll(list, Arrays.asList(array));
        list = Arrays.stream(array).boxed().collect(Collectors.toList());
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
