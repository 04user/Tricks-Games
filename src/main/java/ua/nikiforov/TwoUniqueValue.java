package ua.nikiforov;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Sergey Nikiforov
 */
public class TwoUniqueValue {
    public static void main(String[] args) {
        int[] aruur = {1, 2, 3, 4, 7, 9, 4, 3, 2, 1};

        StringTokenizer stringTokenizer = new StringTokenizer(";12312", ";");

        /*
        String string = new String(new char[]{'a', 'b'});

        for (char a : string.toCharArray()) {
            System.out.println(a);
        }
        */
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }


    }
}
