package ua.nikiforov.string;

import org.apache.commons.lang.WordUtils;

/**
 * @author Sergey Nikiforov
 */
public class WordWrapTest {
    public static void main(String[] args) {
//        String wraped = WordUtils.wrap("This is a simple test string!", 4, "'", true);
        String wraped = WordUtils.capitalizeFully("This is a simple test string!"/*, "as".toCharArray()*/);
        System.out.println(wraped);
    }
}
