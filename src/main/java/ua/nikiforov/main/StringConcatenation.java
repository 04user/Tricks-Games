package ua.nikiforov.main;

/**
 * @author Sergey Nikiforov
 */
public class StringConcatenation {
    public static void main(String[] args) {
        String s1 = "asd";
        String s2 = new String("as"+"d").intern();

        System.out.println(s1==s2);

        System.out.println(s1.hashCode()+" "+s2.hashCode());
//        makeString("asdfsd");
    }

    private static void makeString(String s) {
        String str = "Hello ";
        str = str + s;
        str = str + s;
        str = str + s;
        str = str + s;
        System.out.println(str);
    }
}
