package ru.vasileva.people;

public final class Name {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Name(String firstName, String middleName, String lastName) {
        if (isBlank(firstName) && isBlank(middleName) && isBlank(lastName)) {
            throw new IllegalArgumentException("Имя должно содержать хотя бы одну непустую часть");
        }
        this.firstName = clean(firstName);
        this.middleName = clean(middleName);
        this.lastName = clean(lastName);
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String clean(String value) {
        return isBlank(value) ? null : value.trim();
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (lastName != null) result.append(lastName).append(" ");
        if (firstName != null) result.append(firstName).append(" ");
        if (middleName != null) result.append(middleName);
        return result.toString().trim();
    }
}
