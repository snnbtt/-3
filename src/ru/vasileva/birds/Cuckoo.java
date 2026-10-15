package ru.vasileva.birds;

import java.util.Random;

public class Cuckoo extends Bird {
    private final Random random = new Random();

    public Cuckoo() { super("Кукушка"); }

    @Override
    public void sing() {
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }

    @Override
    public String toString() { return getName(); }
}
