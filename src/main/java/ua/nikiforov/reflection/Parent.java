package ua.nikiforov.reflection;

/**
 * @author Sergey Nikiforov
 */
public class Parent {
    static {
        System.out.println("static initializer of class Parent");
    }

    {
        System.out.println("initializer of class Parent");
    }

    private String field = "Simple it's just text";

    public Parent() {
        System.out.println("Initialize Parent");
    }

    public Parent(String field) {
        System.out.println("Parent(String)");
        this.field = field;
    }

    protected void whoIsIt() {
        System.out.println("This is the Parent");
    }

}
