package ua.nikiforov.main.npe; class Formatter {
    public String format(String value) {
        return "[" + value + "]";
    }
}

public class TestNPE {
    public static String handle(Formatter f, String s) {
//        if (s.isEmpty()) {
        if ("".equals(s)) {
            return "(none)";
        }
        return f.format(s.trim());
    }

    public static void main(String[] args) {
        int a = 0xFF0;
        int b = 0xF0F;
        int c = 0x0FF;

        c = a = (a ^ b | a & b) ^ c;
        System.out.println((c | a) ^ (c & a));
    }
}
