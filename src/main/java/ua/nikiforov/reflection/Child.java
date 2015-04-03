package ua.nikiforov.reflection;

/**
 * @author Sergey Nikiforov
 */
public final class Child extends Parent {
    public Child() {
        System.out.println("Initialize Child");
    }

    public Child(String field) {
        System.out.println("Child(String)");
//        super(field);
    }

    @Override
    public void whoIsIt() {
        System.out.println("This is the Child");
    }
}
