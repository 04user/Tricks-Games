package ua.nikiforov.main;

public class TestInstanceof {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat kitty = new Kitty();

        if (cat instanceof Kitty) {
            System.out.println(true);
        }
    }


    static class Cat {}
    static class Kitty extends Cat{}
}
