package ru.vasileva.main;

import ru.vasileva.geometry.Point;
import ru.vasileva.geometry.Point3D;
import ru.vasileva.people.Name;
import ru.vasileva.people.Person;
import ru.vasileva.birds.Bird;
import ru.vasileva.birds.Sparrow;
import ru.vasileva.birds.Cuckoo;
import ru.vasileva.birds.Parrot;
import ru.vasileva.secrets.Secret;
import ru.vasileva.animals.Cat;
import ru.vasileva.animals.Meowable;
import ru.vasileva.animals.MeowingToy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Лабораторная работа №3. Вариант 3");
        System.out.println("\n1. Непустое имя и изменяемый человек");
        try {
            Name fatherName = new Name("Иван", null, "Васильев");
            Person father = new Person(fatherName, 180, null);
            Name childName = new Name("Анна", "Ивановна", "Васильева");
            Person child = new Person(childName, 165, father);
            System.out.println(father);
            System.out.println(child);
            System.out.print("Введите новый рост Анны (1-500): ");
            int height = readInt(scanner);
            child.setHeight(height);
            System.out.println("После изменения: " + child);
            try {
                new Name(null, " ", "");
            } catch (IllegalArgumentException e) {
                System.out.println("Проверка имени сработала: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        System.out.println("\n2. Передача секрета");
        try {
            Secret secret = new Secret("Маша", "Я выучила новую тему");
            Secret secret2 = secret.tellTo("Катя");
            System.out.println(secret);
            System.out.println(secret2);
            System.out.println("Номер хранителя Кати: " + secret2.getNumberInChain());
            try {
                secret.tellTo("Петя");
            } catch (IllegalStateException e) {
                System.out.println("Повторная передача запрещена: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка секрета: " + e.getMessage());
        }

        System.out.println("\n3. Трёхмерная точка");
        Point3D point3D = new Point3D(2, 4, 6);
        System.out.println("Точка: " + point3D);

        System.out.println("\n4–5. Птицы и полиморфный вызов пения");
        Bird[] birds = { new Sparrow(), new Cuckoo(), new Parrot("Привет, Java!") };
        Methods.birdMarket(birds);

        System.out.println("\n5. Мяуканье (интерфейс Meowable)");
        Meowable[] meowingObjects = {
                new Cat("Мурка"),
                new Cat("Барсик"),
                new Cat("Пушок"),
                new MeowingToy("Игрушечный кот")
        };
        Methods.meowAll(meowingObjects);

        System.out.println("\n6. Сравнение точек через equals()");
        Point first = new Point(3, 5);
        Point second = new Point(3, 5);
        System.out.println("Первая точка: " + first);
        System.out.println("Вторая точка: " + second);
        System.out.println("Точки равны: " + first.equals(second));

        System.out.println("\n7. Возведение в степень");
        if (args.length >= 2) {
            try {
                System.out.println(args[0] + " в степени " + args[1] + " = " +
                        Methods.power(args[0], args[1]));
            } catch (NumberFormatException e) {
                System.out.println("Аргументы командной строки должны быть целыми числами.");
            }
        } else {
            System.out.print("Введите целое число X: ");
            String x = scanner.nextLine().trim();
            System.out.print("Введите целое число Y: ");
            String y = scanner.nextLine().trim();
            try {
                System.out.println(x + " в степени " + y + " = " + Methods.power(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Нужно вводить целые числа.");
            }
        }

        System.out.println("\n8. Клонирование точки");
        Point original = new Point(7, 9);
        Point copy = original.clone();
        copy.setX(100);
        System.out.println("Оригинал: " + original);
        System.out.println("Копия после изменения: " + copy);
        System.out.println("Это один объект: " + (original == copy));

        scanner.close();
        System.out.println("\nРабота программы завершена.");
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String value = scanner.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.print("Введите целое число: ");
            }
        }
    }
}
