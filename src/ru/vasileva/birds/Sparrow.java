package ru.vasileva.birds;

public class Sparrow extends Bird {
    public Sparrow() { super("Воробей"); }

    @Override
    public void sing() {
        System.out.println("чырык");
    }

    @Override
    public String toString() { return getName(); }
}
