package ua.nikiforov.main;

/**
 * Вывести на консоль слово "Right" не меняя сигнатуру первого метода.
 *
 * @author Sergey Nikiforov
 */
class TwoMainMethods {

    private static class InnerClass {
        public static void main(String[] args) {
            System.out.println("Wrong");
        }
    }

    public static void main(String[] args) {
        System.out.println("Right");
    }
}


    /*
    class String{}

    public static void main(java.lang.String[] args) {
        System.out.println("Right");
    }
    */
