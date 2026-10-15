package ru.vasileva.secrets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Secret {
    private final String keeperName;
    private final String text;
    private final List<String> history;
    private boolean passed;
    private final Random random = new Random();

    public Secret(String keeperName, String text) {
        if (keeperName == null || keeperName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя хранителя не должно быть пустым");
        }
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Секрет не должен быть пустым");
        }
        this.keeperName = keeperName.trim();
        this.text = text;
        this.history = new ArrayList<>();
        history.add(this.keeperName);
        System.out.println(this.keeperName + " знает секрет: " + this.text);
    }

    private Secret(String keeperName, String text, List<String> history) {
        this.keeperName = keeperName;
        this.text = text;
        this.history = new ArrayList<>(history);
        this.history.add(keeperName);
        System.out.println(this.keeperName + " знает секрет: " + this.text);
    }

    public Secret tellTo(String newKeeper) {
        if (passed) {
            throw new IllegalStateException("Этот хранитель уже передал секрет дальше");
        }
        if (newKeeper == null || newKeeper.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя нового хранителя не должно быть пустым");
        }
        if (history.contains(newKeeper.trim())) {
            throw new IllegalArgumentException("Этот человек уже знает секрет");
        }
        passed = true;
        System.out.println(keeperName + " сказал что " + text);
        String changedText = addRandomCharacters(text);
        return new Secret(newKeeper.trim(), changedText, history);
    }

    private String addRandomCharacters(String source) {
        int max = source.length() / 10;
        int count = max == 0 ? 0 : random.nextInt(max + 1);
        StringBuilder result = new StringBuilder(source);
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < count; i++) {
            int position = random.nextInt(result.length() + 1);
            char symbol = symbols.charAt(random.nextInt(symbols.length()));
            result.insert(position, symbol);
        }
        return result.toString();
    }

    public int getNumberInChain() { return history.size(); }
    public int getPeopleAfter() { return 0; }
    public String getRelativeKeeperName(int offset) {
        int index = history.size() - 1 + offset;
        if (index < 0 || index >= history.size()) return null;
        return history.get(index);
    }
    public int getLengthDifference(Secret other) {
        if (other == null) throw new IllegalArgumentException("Секрет не должен быть null");
        return text.length() - other.text.length();
    }

    @Override
    public String toString() {
        return keeperName + ": это секрет";
    }
}
