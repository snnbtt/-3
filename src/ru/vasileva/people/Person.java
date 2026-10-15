package ru.vasileva.people;

public class Person {
    private final Name name;
    private final Person father;
    private int height;

    public Person(Name name, int height, Person father) {
        if (name == null) throw new IllegalArgumentException("Имя не должно быть null");
        this.name = name;
        this.father = father;
        setHeight(height);
    }

    public Name getName() { return name; }
    public Person getFather() { return father; }
    public int getHeight() { return height; }

    public void setHeight(int height) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException("Рост должен быть от 1 до 500");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return "Человек: " + name + ", рост " + height +
                ", отец: " + (father == null ? "не указан" : father.getName());
    }
}
