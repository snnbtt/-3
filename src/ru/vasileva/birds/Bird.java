package ru.vasileva.birds;

public abstract class Bird {
    private final String name;

    public Bird(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название птицы не должно быть пустым");
        }
        this.name = name.trim();
    }

    public String getName() { return name; }
    public abstract void sing();

    @Override
    public String toString() {
        return name;
    }
}
