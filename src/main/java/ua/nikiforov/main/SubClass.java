package ua.nikiforov.main;

/**
 * @author Sergey Nikiforov
 */
class SuperClass {
    public int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}

public class SubClass extends SuperClass {
    public int field;

    @Override
    public int getField() {
        return field;
    }

    @Override
    public void setField(int field) {
        this.field = field;
    }

    public static void main(String[] args) {
        SuperClass instance = new SubClass();
        instance.field = 1;

        System.out.println(instance.getField());
    }
}
