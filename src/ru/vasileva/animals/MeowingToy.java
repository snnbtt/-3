package ru.vasileva.animals;

public class MeowingToy implements Meowable {
    private final String name;

    public MeowingToy(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название игрушки не должно быть пустым");
        }
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу-мяу");
    }

    @Override
    public String toString() {
        return "Игрушка, которая мяукает: " + name;
    }
}
