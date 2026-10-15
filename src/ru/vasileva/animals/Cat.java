package ru.vasileva.animals;

public class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя кота не должно быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу");
    }

    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
