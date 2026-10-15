package ru.vasileva.birds;

import java.util.Random;

public class Parrot extends Bird {
    private final String phrase;
    private final Random random = new Random();

    public Parrot(String phrase) {
        super("Попугай");
        if (phrase == null || phrase.isEmpty()) {
            throw new IllegalArgumentException("Текст попугая не должен быть пустым");
        }
        this.phrase = phrase;
    }

    @Override
    public void sing() {
        int count = random.nextInt(phrase.length()) + 1;
        System.out.println(phrase.substring(0, count));
    }

    @Override
    public String toString() {
        return getName() + " (текст: " + phrase + ")";
    }
}
