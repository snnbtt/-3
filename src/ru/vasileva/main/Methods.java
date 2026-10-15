package ru.vasileva.main;

import ru.vasileva.birds.Bird;
import ru.vasileva.animals.Meowable;

public class Methods {
    public static void birdMarket(Bird[] birds) {
        for (Bird bird : birds) {
            bird.sing();
        }
    }

    public static void meowAll(Meowable[] objects) {
        for (Meowable object : objects) {
            object.meow();
        }
    }

    public static double power(String x, String y) {
        return Math.pow(Integer.parseInt(x), Integer.parseInt(y));
    }
}
